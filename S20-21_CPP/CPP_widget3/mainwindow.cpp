#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    // ui ist ein ptr
    //ui-> pushButton->setText("APPEND");

    ui -> pushButton->setText("APPEND");
    ui -> pushButton_2->setText("CLEAR");
    ui -> pushButton_3->setText("CLOSE");
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_pushButton_clicked()
{
    // ui -> lineEdit_2 -> setText(ui -> lineEdit -> text());
    ui -> lineEdit_2 -> setText(ui->lineEdit_2->text() + ui->lineEdit->text());
}
