#ifndef TASCHENRECHNER_H
#define TASCHENRECHNER_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui { class taschenrechner; }
QT_END_NAMESPACE

class taschenrechner : public QMainWindow
{
    Q_OBJECT

public:
    taschenrechner(QWidget *parent = nullptr);
    ~taschenrechner();

private:
    Ui::taschenrechner *ui;
};
#endif // TASCHENRECHNER_H
