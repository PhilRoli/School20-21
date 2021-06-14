#ifndef COMPLEX_H
#define COMPLEX_H

#include <QString>

class Complex
{
public:
    Complex();
    Complex(double real, double imag);

    QString toString();
    Complex operator+(Complex const &other);
    Complex operator-(Complex const &other);

    double getReal();
    double getImag();

private:
    double mReal;
    double mImag;
};

#endif // COMPLEX_H
