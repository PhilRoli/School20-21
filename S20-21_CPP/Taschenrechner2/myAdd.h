#ifndef MYADD_H
#define MYADD_H

#include <QWidget>

class Taschenrechner;

class myAdd : public QWidget
{
    Q_OBJECT

    Taschenrechner *myTaschenrechner;

public:
    myAdd(Taschenrechner *);
    ~myAdd();
private slots:
    void addAB();
};

#endif //MYADD_H
