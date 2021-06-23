#include <iostream>

using namespace std;

struct Listenelement
{
    string daten;

    Listenelement *nachfolger;
    Listenelement *vorganger;
};

int main()
{
    cout << "-----------Listen-----------" << endl;

    Listenelement *liste = new Listenelement();

    liste->daten = "Datensatz 1: Information";
    liste->nachfolger = NULL;
    liste->vorganger = NULL;

    Listenelement *liste2 = new Listenelement();

    liste2->daten = "Datensatz 2: Information";
    liste2->nachfolger = NULL;
    liste2->vorganger = liste;

    // Link Lists
    liste->nachfolger = liste2;

    Listenelement *p;
    Listenelement *o;
    o = liste;
    p = liste;
    // while (p->vorganger != NULL || p == o)
    // {
    //     cout << liste->daten << endl;

    //     // Nachfolger wird zum aktiven element
    //     p = p->nachfolger;
    // }

    do
    {
        cout << liste->daten << endl;

        // Nachfolger wird zum aktiven element
        p = p->nachfolger;
    } while (p->nachfolger != NULL);

    return 0;
}
