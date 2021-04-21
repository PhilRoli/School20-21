#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QFile>
#include <QTextStream>
#include <QMessageBox>
#include <QFileDialog>

// Push Buttons werden zu einem Späteren Zeitpunkt entfernt, derzeit da um schneller auf
// die funktionen zugreifen zu können

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    // Öffnet Explorer
    connect(ui->actionOpen, SIGNAL(triggered()), this, SLOT(fileOpen()));
    connect(ui->buttonOpen, SIGNAL(clicked()), this, SLOT(fileOpen()));

    // Speichert die Datei
    connect(ui->actionSave, SIGNAL(triggered()), this, SLOT(fileSave()));
    connect(ui->buttonSave, SIGNAL(clicked()), this, SLOT(fileSave()));

    // Leert den inhalt des Text Feldes
    connect(ui->actionClear, SIGNAL(triggered()), this, SLOT(fileClear()));
    connect(ui->buttonClear, SIGNAL(clicked()), this, SLOT(fileClear()));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::fileSave()
{
    if(windowTitle() == "Text Editor")
    {
        QMessageBox::warning(this, "Error", "Es ist derzeit keine Datei geöffnet");
        return;
    }

    QFile file(windowTitle());

    if (!file.open(QFile::WriteOnly | QFile::Text))
    {
        QMessageBox::warning(this, "Error", "File not open");
    }

    QTextStream out(&file);
    QString editorContent = ui->plainTextEdit->toPlainText();
    out << editorContent;
    file.flush();
    file.close();
}

void MainWindow::fileOpen()
{
    QString file_name = QFileDialog::getOpenFileName(this, "Open File", "C://");
    if( file_name == NULL) {
        return;
    }

    QFile file(file_name);

    if (!file.open(QFile::ReadOnly | QFile::Text))
    {
        QMessageBox::warning(this, "Error", "File not open");
        return;
    }

    setWindowTitle(file_name);
    QTextStream in(&file);
    QString fileContent = in.readAll();
    ui->plainTextEdit->setPlainText(fileContent);
    file.close();
}

void MainWindow::fileClear()
{
    ui->plainTextEdit->clear();
    setWindowTitle("Text Editor");
}
