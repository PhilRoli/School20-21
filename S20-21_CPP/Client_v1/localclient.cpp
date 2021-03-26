#include "localclient.h"

using namespace std;

LocalClient::LocalClient(QObject *parent) : QObject(parent)
{
}

void LocalClient::Connect()
{
    socket = new QTcpSocket(this);

    socket->setSocketOption(QAbstractSocket::KeepAliveOption, 1);

    socket->connectToHost("127.0.0.1", 1234);

    while (1)
    {
        socket->waitForBytesWritten(1000);

        socket->waitForReadyRead(3000);

        if (socket->bytesAvailable() > 0)
        {
            //qDebug() << "Reading" << socket->bytesAvailable() - 2;

            string messageInRaw;
            messageInRaw = socket->readAll().toStdString();

            string messageIn = messageInRaw.erase(messageInRaw.size() - 2);

            cout << "Server: " << messageIn << endl;
        }
    }
}
