#ifndef LOCALCLIENT_H
#define LOCALCLIENT_H

#include <QObject>
#include <QTcpSocket>
#include <QDebug>

#include <string>
#include <iostream>

class LocalClient : public QObject
{
    Q_OBJECT
public:
    explicit LocalClient(QObject *parent = nullptr);

    void Connect();

signals:

public slots:

private:
    QTcpSocket *socket;
};

#endif // LOCALCLIENT_H
