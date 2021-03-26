#include "localserver.h"

using namespace std;

LocalServer::LocalServer(QObject *parent) : QObject(parent)
{
    server = new QTcpServer(this);

    connect(server, SIGNAL(newConnection()), this, SLOT(TalkToClient()));

    if (!server->listen(QHostAddress::LocalHost, 1234))
    {
        qDebug() << "Server unable to Start";
    }
    else
    {
        qDebug() << "Server Startet";
    }
}

void LocalServer::newConnection()
{
    QTcpSocket *socket = server->nextPendingConnection();

    socket->write("Hello Client!\r\n");
    socket->flush();

    socket->waitForBytesWritten(3000);

    socket->close();
}

void LocalServer::TalkToClient()
{
    QTcpSocket *socket = server->nextPendingConnection();
    bool run = true;

    while (run == true)
    {
        string message;
        cout << ":";
        getline(cin, message);

        message.append("\r\n");

        int n = message.length();
        char message_arr[n + 1];

        strcpy(message_arr, message.c_str());

        socket->write(message_arr);
        socket->flush();
    }
}
