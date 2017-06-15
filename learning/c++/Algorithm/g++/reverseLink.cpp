#include <iostream>
#include <string>
#include <memory>

using namespace std;

struct Item {
    unique_ptr<Item> upNext;
    string strData;
};

class ReverseLink {
    unique_ptr<Item> upHeader;

public:
    ReverseLink() : upHeader { nullptr } {}
    ReverseLink( int ItemNumber )
    {
        upHeader = unique_ptr<Item>{new Item};
        upHeader->strData = "";
        upHeader->upNext = nullptr;

        unique_ptr<Item> temp;
        for (auto i = 0; i < ItemNumber; i++) {
            temp = unique_ptr<Item>{new Item};
            temp->strData = to_string(i);
            temp->upNext = move(upHeader->upNext);
            upHeader->upNext = move(temp);
        }
    }

    void print()
    {
        auto temp = upHeader.get();
        cout << "The single linked list is:" << endl;
        while (temp)
        {
            cout << temp->strData << " ";
            temp = temp->upNext.get();
        }
        cout << endl;
    }

    void reverse()
    {
        auto temp = upHeader.get();
        if (temp == nullptr)
            return;
        if (temp->upNext == nullptr)
            return;
        temp = temp->upNext.get();
        if (temp->upNext == nullptr)
            return;

        unique_ptr<Item> upCurrent {move(upHeader->upNext)};
        unique_ptr<Item> upRemain {move(upCurrent->upNext->upNext)};
        unique_ptr<Item> upNext {move(upCurrent->upNext)};
        upNext->upNext = move(upCurrent);
        upHeader->upNext = move(upNext);

        while (upRemain)
        {
            upCurrent = move(upRemain);
            upRemain = move(upCurrent->upNext);
            upCurrent->upNext = move(upHeader->upNext);
            upHeader->upNext = move(upCurrent);
        }
    }

    ~ReverseLink()
    {
        while ( upHeader )
        {
            unique_ptr<Item> temp = move(upHeader);
            upHeader = move(temp->upNext);
            temp.release();
        }
    }
};

int main(void)
{
    ReverseLink rLink{10};
    rLink.print();
    cout << "After reversed: " << endl;
    rLink.reverse();
    rLink.print();
    return 0;
}
