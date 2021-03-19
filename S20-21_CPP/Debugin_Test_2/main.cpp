#include <iostream>

using namespace std;

void fun(int* ptr){
    cout << *ptr << endl;
}

int main() {
    int a = 42;
    int*b = nullptr;

    fun(&a);
    fun(b);

    return 0;
}
