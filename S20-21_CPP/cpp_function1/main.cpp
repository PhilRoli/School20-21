#include <iostream>

using namespace std;

// void, funktion rufen, prameter klammer
// Funktion über main deklarieren, kann aber erst später definiert werden.

// Call by Value
/*
 * Hierbei wird der wert kopiert, und änderungen auf den
 * neuen Parameter haben keinen Einfluss auf den Ursprungsparameter
*/

// Call by Refrence
/*
 * Änderungen an dem übertragenen Parameter werden auch auf den ursprungsparameter übergeben
*/

void myFunction(); // Deklarieren
int plusFunc(int x, int y);
double plusFunc(double x, double y);

int main()
{
    cout << "Hello World!" << endl;

    myFunction();

    int myNum1 = plusFunc(8,4);
    double myNum2 = plusFunc(4.3, 6.26);

     cout << "Int: " << myNum1 << endl;
     cout << "Dobule: " << myNum2 << endl;

    return 0;
}

void myFunction() // definieren
{
    cout << "Hello Function" << endl;
}

int plusFunc(int x, int y) {
  return x + y;
}

double plusFunc(double x, double y) {
  return x + y;
}
