#include "taschenrechner.h"
#include "ui_taschenrechner.h"

taschenrechner::taschenrechner(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::taschenrechner)
{
    ui->setupUi(this);
}

taschenrechner::~taschenrechner()
{
    delete ui;
}

