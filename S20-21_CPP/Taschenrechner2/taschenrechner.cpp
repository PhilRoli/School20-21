#include "taschenrechner.h"
#include "ui_taschenrechner.h"
#include "myAdd.h"
#include "mySub.h"

Taschenrechner::Taschenrechner(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::Taschenrechner)
{
    myAdd *addWidget = new myAdd(this);
    mySub *subWidget = new mySub(this);

    ui->setupUi(this);
    ui->InputA->insert("0");
    ui->InputB->insert("0");
    ui->InputA_2->insert("0");
    ui->InputB_2->insert("0");

    connect(ui->Calculate, SIGNAL(clicked()), addWidget, SLOT(addAB()));
    connect(ui->Calculate_2, SIGNAL(clicked()), subWidget, SLOT(subAB()));
    connect(ui->actionQuit, SIGNAL(triggered()), qApp, SLOT(slotClose()));
    connect(ui->actionAdd, SIGNAL(triggered()), this, SLOT(showAdd()));
    connect(ui->actionSub, SIGNAL(triggered()), this, SLOT(showSub()));
}

Taschenrechner::~Taschenrechner()
{
    delete ui;
}

void Taschenrechner::slotClose()
{
    close();
}

void Taschenrechner::showAdd()
{
    ui->stackedWidget->setCurrentIndex(0);
}

void Taschenrechner::showSub()
{
    ui->stackedWidget->setCurrentIndex(1);
}
