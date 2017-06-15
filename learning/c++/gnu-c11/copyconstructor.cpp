#include <iostream>
using namespace std;

class HasPtrMem
{
public:
    HasPtrMem() : d{new int(0)} {}
    HasPtrMem(const HasPtrMem & h) :
        d{new int(*(h.d))}
    {
        cout << "Const copy constructor is used!" << endl;
    }

    HasPtrMem(HasPtrMem & h) :
        d{new int(*(h.d))}
    {
        cout << "Copy constructor is used!" << endl;
    }

    ~HasPtrMem()
    {
        cout << "class HasPtrMem is destrcuted!" << d << endl;
        delete d;
    }

    int * d { nullptr };
};

int main()
{
    HasPtrMem a;
    HasPtrMem b(a);
    cout << *(a.d) << endl;
    cout << *(b.d) << endl;
}
