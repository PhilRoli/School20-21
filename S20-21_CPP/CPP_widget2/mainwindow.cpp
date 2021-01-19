#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    // ui ist ein ptr
    ui->pushButton->setText("Hallo");
}

MainWindow::~MainWindow()
{
    delete ui;
}

