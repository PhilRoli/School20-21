#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QFile>
#include <QTextStream>
#include <QMessageBox>
#include <QFileDialog>

//! Push Buttons werden zu einem Späteren Zeitpunkt entfernt, derzeit da um schneller auf
//! die funktionen zugreifen zu können

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
    // Wenn der fenster Titel kein Datei Pfad ist, aussteigen
    if (windowTitle() == "Text Editor")
    {
        QMessageBox::warning(this, "Fehler", "Es ist derzeit keine Datei geöffnet");
        return;
    }

    // Wenn nicht ausgestiegen, speicher die Datei im Pfad des Fenster Titels
    QFile file(windowTitle());

    // Falls die datei nicht geöffnet werden kann (gelöscht etc)
    // Fehlermeldung + aussteigen
    if (!file.open(QFile::WriteOnly | QFile::Text))
    {
        QMessageBox::warning(this, "Fehler", "Datei kann nicht gespeichet werden.");
        return;
    }

    // Nehmen des TextFeld inhaltes und in die Datei speichern
    QTextStream out(&file);
    QString editorContent = ui->plainTextEdit->toPlainText();
    out << editorContent;
    file.flush();
    file.close();
}

void MainWindow::fileOpen()
{
    // Öffnen der Explorer Fensteres und öffnen einer Datei
    QString file_name = QFileDialog::getOpenFileName(this, "Open File", "C://");
    // Sollte auf "abbrechen" geklickt worden sein, aussteigen
    if (file_name == NULL)
    {
        return;
    }

    // Öffnen der Datei
    QFile file(file_name);

    // Sollte die datei nicht geöffnet werden können -> aussteigen
    if (!file.open(QFile::ReadOnly | QFile::Text))
    {
        QMessageBox::warning(this, "Fehler", "Datei konnte nicht geöffnet werden");
        return;
    }

    // Fenster Titel als Pfad + Dateinamen festlegen
    setWindowTitle(file_name);
    // Inhalt der Datei in Text Feld laden
    QTextStream in(&file);
    QString fileContent = in.readAll();
    ui->plainTextEdit->setPlainText(fileContent);
    file.close();
}

void MainWindow::fileClear()
{
    // leeren des Text Felds
    ui->plainTextEdit->clear();
    // Fenster Titel auf original ändern
    setWindowTitle("Text Editor");
}
