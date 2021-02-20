#include "taschenrechner.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    taschenrechner w;
    w.show();
    return a.exec();
}
