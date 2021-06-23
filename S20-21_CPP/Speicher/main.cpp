#include <iostream>

using namespace std;

int main()
{
    cout << "Speicher" << endl;

    double zahl;
    zahl = 7;

    double *pdbl;

    int size_of_array = 100;
    int *iarr;

    // malloc, calloc, realloc - free

    // pdbl = (double *)malloc(sizeof(double));
    // cout << "*pdbl (nach malloc) = " << *pdbl << endl;
    pdbl = (double *)calloc(1, sizeof(double));
    cout << "*pdbl (nach calloc) = " << *pdbl << endl;

    *pdbl = 99;

    free(pdbl);
    pdbl = &zahl;

    cout << "Groesse von double = " << sizeof(double) << endl;
    cout << "*pdbl = " << *pdbl << endl;

    iarr = (int *)calloc(size_of_array, sizeof(int));
    cout << "Inhalt iarr[5] = " << iarr[5] << endl;

    free(iarr);

    return 0;
}
