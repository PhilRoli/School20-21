#include "mySub.h"
#include "taschenrechner.h"
#include "ui_taschenrechner.h"

mySub::mySub(Taschenrechner *TRechner) : myTaschenrechner(TRechner)
{
}

mySub::~mySub()
{
}

void mySub::subAB()
{
    double a, b;
    a = (myTaschenrechner->ui->InputA_2->text()).toDouble();
    b = (myTaschenrechner->ui->InputB_2->text()).toDouble();
    myTaschenrechner->ui->ResultC_2->setText(QString("%1").arg(a - b, 0, 'f', 4));
}
