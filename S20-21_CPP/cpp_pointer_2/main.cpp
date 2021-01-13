#include <iostream>

using namespace std;

void setText(string text, string *pText);

int main()
{
    cout << "Pointer die 2.!" << endl;

    double zahl = 0.;
    string text;

    // 2 Arten für den Pointer

    // berechne(wert1 => wert2)
    double *p = &zahl;
    // double* ptr
    // int* ptr_i

    // an der Adresse p will ich den Wert 3.14 zuweisen
    *p = 3.14;
    cout << "*p: " << *p << endl;

    cout << "zahl: " << zahl << endl;

    // Methode setText ("...parameter..."):
    // es soll eine variable text (Zeichenkette) im aufrufenden Programm deklariert werden
    // in der Funktion soll ein Wert ("gesetzt") zugewiesen + zurückgeben

    setText("Das ist ein String!", &text);
    cout << "Text: " << text << endl;

    return 0;
}

void setText(string text, string *pText)
{
    *pText = text;
}
