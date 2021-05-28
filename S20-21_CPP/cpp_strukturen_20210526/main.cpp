#include <iostream>
#include <stdlib.h>

using namespace std;

struct person
{
    string vorname;
    string nachname;
    int alter;
    string geschlecht;
    double groesse;
    double gewicht;
};

struct adresse
{
    string strasse;
    int hausnummer;
    string ort;
    int postleitzahl;
};

void ausgabe(struct person mensch);

void eingeben(struct person *p)
{
    cout << "Vorname: ";
    cin >> p->vorname;
    cout << endl;
    cout << "Alter: ";
    cin >> p->alter;
};

int main()
{
    cout << "Strukturen" << endl;

    person mensch = {
        "Max",
        "Mustermann",
        34,
        "Maennlich",
        180.00,
        80.00};

    mensch.alter = 30;

    person schueler;
    schueler.alter = 17;
    schueler.vorname = "Schueler";

    ausgabe(mensch);

    // Groesse
    cout << "Groesse Mensch: " << sizeof(mensch) << endl;
    cout << "Groesse Schueler: " << sizeof(schueler) << endl;

    person dritte;
    eingeben(&dritte);
    ausgabe(dritte);

    return 0;
}

void ausgabe(struct person mensch)
{
    cout << "Name = " << mensch.vorname << " " << mensch.nachname << endl;
    cout << "Alter = " << mensch.alter << " Geschlecht = " << mensch.geschlecht << endl;
}
