#ifndef MYSUB_H
#define MYSUB_H

#include <QWidget>

class Taschenrechner;

class mySub : public QWidget
{
    Q_OBJECT

    Taschenrechner *myTaschenrechner;

public:
    mySub(Taschenrechner *);
    ~mySub();
private slots:
    void subAB();
};

#endif // MYSUB_H
