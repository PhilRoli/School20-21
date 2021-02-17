#include "myAdd.h"
#include "taschenrechner.h"
#include "ui_taschenrechner.h"

myAdd::myAdd(Taschenrechner *TRechner) : myTaschenrechner(TRechner)
{
}

myAdd::~myAdd()
{
}

void myAdd::addAB()
{
    double a, b;
    a = (myTaschenrechner->ui->InputA->text()).toDouble();
    b = (myTaschenrechner->ui->InputB->text()).toDouble();
    myTaschenrechner->ui->ResultC->setText(QString("%1").arg(a + b, 0, 'f', 4));
}
