#include <iostream>

using namespace std;

void setText(string text, string *pText);
void setTextArray(char *array, string *newString);

int main()
{
    cout << "Pointer die 2.!" << endl;

    double zahl = 0.;
    string text;
    string newString;
    char cArray[] = {'N', 'e', 'u', 'e', 'r', ' ', 'S', 't', 'r', 'i', 'n', 'g', '!', '\0'};
    // '\0' löst das 3 zeichen am ende problem das unten gelöst wird

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

    setTextArray(cArray, &newString);
    cout << "Text: " << newString << endl;

    return 0;
}

void setText(string text, string *pText)
{
    *pText = text;
}

void setTextArray(char *array, string *newString)
{
    string nString(array);
    // Aufgrund von problemen mit std::string (welches benutzt wird um das array in einen string zu formen, wird am ende von nString folgendes angehängt: ��a)
    // Das problem bezieht sich auf folgendes: cArray gibt im Debug modus folgendes zurück "-var-create unable to create variable object" -> https://stackoverflow.com/questions/41854840/var-create-unable-to-create-variable-object
    // Um dieses problem auf dem einfachsten weg zu umgehen, schneiden wir die letzten 3 chars des strings ab
    // Die andere möglichkeit dieses Problem zu lösen, wäre indem man zuerst einen leeren string erstellet, und diesen dann durch eine schleife mit den einzelenen chars befüllt.
    // *newString = nString.substr(0, nString.size() - 3);
    *newString = nString;
    // Durch das '\0' ist es nicht mehr nötig die letzten 3 zeichen abzuschneiden
}
