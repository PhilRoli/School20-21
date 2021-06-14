#include "complex.h"

Complex::Complex()
{
}

Complex::Complex(double real, double imag)
{
    mReal = real;
    mImag = imag;
}

QString Complex::toString()
{
    return QString::number(mReal) + " + " + QString::number(mImag) + "j";
}

Complex Complex::operator+(const Complex &other)
{
    double real = mReal + other.mReal;
    double imag = mImag + other.mImag;
    return Complex(real, imag);
}

Complex Complex::operator-(const Complex &other)
{
    double real = mReal - other.mReal;
    double imag = mImag - other.mImag;
    return Complex(real, imag);
}

double Complex::getReal()
{
    return this->mReal;
}

double Complex::getImag()
{
    return this->mImag;
}
