#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QTextStream>
#include <QMessageBox>
#include <QFile>
#include <iostream>

using namespace std;

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

    //! -------------------- LoginDataLoader --------------------
    // initialize StringList to store login data
    QStringList loginDataList;

    // read file contents as specified place
    QFile file("C://Users/phili/Documents/temp/logindata.txt");
    // Error Handeling in case file could not be opend
    if (!file.open(QFile::ReadOnly | QFile::Text))
    {
        ui->labelStatus->setText("Error Loading Data!");
        return;
    }

    // reading of file content and splitting at ','
    QTextStream in(&file);
    QString logindata = in.readAll();
    loginDataList = logindata.split(",");

    //! -------------------- LoginDataHandler --------------------

    // reding of username & password from input
    QString usernameGiven = ui->lineUsername->text();
    QString passwordGiven = ui->linePassword->text();

    // initialize variables that are used in the login process
    int whileIndicator = 0;
    char loginCheck = 'x';

    // looping trough the String List, until a Username that matches the input is found
    while (usernameGiven != loginDataList[whileIndicator] && loginCheck != 'u')
    {
        // if DataList size is reached, no matching username could be found
        if (loginDataList.size() <= whileIndicator + 2)
        {
            // No username was found, check variable = u
            loginCheck = 'u';
        }
        else // if (loginCheck != 'u')
        {
            whileIndicator = whileIndicator + 2;
        }
    }

    // if a username was found, check if the password next to it is correct as well
    if (loginCheck != 'u' && passwordGiven == loginDataList[whileIndicator + 1])
    {
        // password matches, login = true
        loginCheck = 't';
    }
    else if (loginCheck != 'u')
    {
        // password did not match, indicate password error
        loginCheck = 'p';
    }

    //! -------------------- LoginDataOutput --------------------
    // depending on loginCheck (specified above in LoginDataHandler), switch case corresponding
    // to loginCheck result
    switch (loginCheck)
    {
    case 'u':
        ui->labelStatus->setText("Username Wrong!");
        ui->lineUsername->setText("");
        ui->linePassword->setText("");
        break;
    case 'p':
        ui->labelStatus->setText("Password Wrong!");
        ui->linePassword->setText("");
        break;
    case 't':
        ui->labelStatus->setText("Login successful!");
        break;
    default:
        ui->labelStatus->setText("Login failed!");
    }
}
