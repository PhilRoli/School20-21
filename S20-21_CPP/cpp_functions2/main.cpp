#include <iostream>

using namespace std;

void berechne_by_value(int par1, int par2, int summe, int produkt);

int main()
{
    int num1 = 10;
    int num2 = 5;
    int summe;
    int produkt;
    berechne_by_value(num1, num2, summe, produkt);

    cout << "E1: " << num1 << " E2: " << num2 << endl;
    cout << "Summe: " << summe << " Produkt: " << produkt << endl;

    return 0;
}

void berechne_by_value(int par1, int par2, int summe, int produkt)
{
    summe = par1 + par2;
    produkt = par1 * par2;
}
