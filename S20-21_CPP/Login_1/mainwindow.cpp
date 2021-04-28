#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QTextStream>
#include <QMessageBox>
#include <QFile>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    setWindowTitle("LogIn Window");
    setWindowIcon(QIcon("C://Users/phili/Pictures/Icons/person.ico"));

    connect(ui->buttonLogin, SIGNAL(clicked()), this, SLOT(clickedLogin()));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::clickedLogin()
{
    QString usernameGiven = ui->lineUsername->text();
    QString passwordGiven = ui->linePassword->text();

    if (usernameGiven == "Admin")
    {
        if (passwordGiven == "root")
        {
            ui->labelStatus->setText("Login successful!");
            return;
        }
        else
        {
            ui->labelStatus->setText("Password Wrong!");
            ui->linePassword->setText("");
            return;
        }
    }
    else
    {
        ui->labelStatus->setText("Username Wrong!");
        ui->linePassword->setText("");
        ui->lineUsername->setText("");
        return;
    }
}
