#ifndef TASCHENRECHNER_H
#define TASCHENRECHNER_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui
{
    class Taschenrechner;
}
QT_END_NAMESPACE

class Taschenrechner : public QMainWindow
{
    Q_OBJECT

public:
    Taschenrechner(QWidget *parent = nullptr);
    ~Taschenrechner();
    Ui::Taschenrechner *ui;

private slots:
    void slotClose();
    void showAdd();
    void showSub();
};
#endif // TASCHENRECHNER_H
