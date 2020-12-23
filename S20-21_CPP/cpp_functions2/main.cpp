#include <iostream>

using namespace std;

void berechne_by_value(int par1, int par2, int summe, int produkt);
void berechne_by_reference(int par1, int par2, int *pSumme, int *pProdukt);
void gib_werte_aus(int par1, double par2, char par3, string par4, bool par5);

int main()
{
    int num1 = 10;
    int num2 = 5;
    int summe = 0;
    int produkt = 0;

    // Zeiger (pointer) auf eine variable
    int *pSumme = &summe;     // pSumem ist ein zeiger, zeigt auf adresse der variablen summe
    int *pProdukt = &produkt; // pSumem ist ein zeiger, zeigt auf adresse der variablen summe

    // berechne_by_value(num1, num2, summe, produkt);
    berechne_by_reference(num1, num2, &summe, &produkt);

    cout << "E1: " << num1 << " E2: " << num2 << endl;
    cout << "Value > Summe: " << summe << " Produkt: " << produkt << endl;
    cout << "& > Summe: " << &summe << " Produkt: " << &produkt << endl;
    cout << "*p > Summe: " << *pSumme << " Produkt: " << *pProdukt << endl;
    cout << endl;

    int parI = 10;
    double parD = 5.2;
    char parC = 'c';
    string parS = "Hallo";
    bool parB = true;
    gib_werte_aus(parI, parD, parC, parS, parB);

    return 0;
}

void berechne_by_value(int par1, int par2, int summe, int produkt)
{
    summe = par1 + par2;
    produkt = par1 * par2;
}
void berechne_by_reference(int par1, int par2, int *pSumme, int *pProdukt)
// pSumme ist ein zeiger auf variablen
{
    *pSumme = par1 + par2; // den Inhalt an der Stelle-Adresse verändern
    *pProdukt = par1 * par2;
}

void gib_werte_aus(int par1, double par2, char par3, string par4, bool par5)
{
    // gib hier die Übergabeparameter aus
    cout << "int-Par.1= " << par1 << endl;
    cout << "double-Par.2= " << par2 << endl;
    cout << "char-Par.3= " << par3 << endl;
    cout << "string-Par.4= " << par4 << endl;
    cout << "bool-Par.5= " << par5 << endl;
}
