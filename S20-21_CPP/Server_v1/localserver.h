#ifndef LOCALSERVER_H
#define LOCALSERVER_H

#include <QObject>
#include <QDebug>
#include <QTcpServer>
#include <QTcpSocket>

#include <string>
#include <iostream>

class LocalServer : public QObject
{
    Q_OBJECT
public:
    explicit LocalServer(QObject *parent = nullptr);

signals:

public slots:
    void newConnection();
    void TalkToClient();

private:
    QTcpServer *server;
};

#endif // LOCALSERVER_H
