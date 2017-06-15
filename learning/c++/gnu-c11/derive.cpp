#include <iostream>

using namespace std;

struct Base
{
    Base() {}
    Base( int i ) { cout << "Base construction:" << i << endl; }
    virtual void f(double i) { cout << "Base:" << i << endl; }
};

struct Derived : Base
{
    using Base::Base;
    void f(int i) { cout << "Derived:" << i << endl; }
};

int main()
{
    Base b;
    b.f(4.5);

    Derived d;
    d.f(5.6);
}
