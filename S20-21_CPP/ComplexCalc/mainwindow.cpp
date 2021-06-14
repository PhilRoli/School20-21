#include "mainwindow.h"
#include "C:\VSC_School20-21\S20-21_CPP\_Build\build-ComplexCalc-Desktop_Qt_5_15_2_MinGW_64_bit-Debug\ui_mainwindow.h"
#include "complex.h"

#include <QMessageBox>
#include <iostream>
using namespace std;

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    setWindowTitle("Complex Calculator");
    setWindowIcon(QIcon("C://Users/phili/Pictures/Icons/png_jpgs_etc/ComplexCalc.png"));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_buttonBerechnen_clicked()
{
    Complex zahl1(ui->spinReal1->value(), ui->spinImag1->value());
    Complex zahl2(ui->spinReal2->value(), ui->spinImag2->value());

    Complex ergebnis;

    if (ui->radioAddieren->isChecked())
    {
        ergebnis = zahl1 + zahl2;
        ui->labelOperator->setText("+");
    }
    else if (ui->radioSubtrahieren->isChecked())
    {
        ergebnis = zahl1 - zahl2;
        ui->labelOperator->setText("-");
    }
    else
    {
        QMessageBox::critical(this, "Error", "No Operator selected!");
        ui->labelErgebnis->setText("No Operator selected!");
        return;
    }

    ui->spinRealErgebnis->setValue(ergebnis.getReal());
    ui->spinImagErgebnis->setValue(ergebnis.getImag());

    ui->label1->setText(zahl1.toString());
    ui->label2->setText(zahl2.toString());
    ui->labelErgebnis->setText(ergebnis.toString());
}
