#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QFile>
#include <QTextStream>
#include <QMessageBox>
#include <QFileDialog>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    setWindowIcon(QIcon("C://Users/phili/Pictures/Icons/book.ico"));

    // Öffnet Explorer
    connect(ui->actionOpen, SIGNAL(triggered()), this, SLOT(fileOpen()));

    // Speichert die Datei
    connect(ui->actionSave, SIGNAL(triggered()), this, SLOT(fileSave()));

    // Leert den inhalt des Text Feldes
    connect(ui->actionClear, SIGNAL(triggered()), this, SLOT(fileClear()));

    // Speichert die Datei neu ab
    connect(ui->actionSave_As, SIGNAL(triggered()), this, SLOT(fileSaveAs()));

    // Erstellt eine neue Datei
    connect(ui->actionNew_File, SIGNAL(triggered()), this, SLOT(fileNewFile()));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::fileSave()
{

    if (windowTitle() == "Neue Datei" || windowTitle() == "Text Editor")
    {
        fileSaveAs();
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

void MainWindow::fileSaveAs()
{
    QString file_name_new = "C://";

    if (windowTitle() != "Neue Datei" || windowTitle() != "Text Editor")
    {
        file_name_new = windowTitle();
    }

    // Öffnen der Explorer Fensteres und öffnen einer Datei
    QString file_name = QFileDialog::getSaveFileName(this, "Save File", file_name_new);
    // Sollte auf "abbrechen" geklickt worden sein, aussteigen
    if (file_name == NULL)
    {
        return;
    }

    // Öffnen der Datei
    QFile file(file_name);
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

void MainWindow::fileNewFile()
{
    // löscht den text feld inhalt un setzt fenster titel zurück
    ui->plainTextEdit->clear();
    setWindowTitle("Neue Datei");
}
