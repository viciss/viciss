#include <vector>
#include <iostream>

using namespace std;

using ElementType = int;
using StaticListItem =
struct Item {
    ElementType data;
    int nNext;
};

class StaticList {
    vector<StaticListItem> m_slArray {};
    int nCount {0};
    int nMaxLen {0};

    int malloc_sl() {
        int nFree = m_slArray[0].nNext;
        if (nFree != 0) {
            // Remove from free list
            int nNext = m_slArray[nFree].nNext;
            m_slArray[0].nNext = nNext;

            // add to used list
            nNext = m_slArray[nMaxLen - 1].nNext;
            m_slArray[nMaxLen - 1].nNext = nFree;
            m_slArray[nFree].nNext = nNext;
            nCount++;
        }

        return nFree;
    }

    void free_sl(int nIndex) {
        // remove from used list
        int nNext = m_slArray[nMaxLen - 1].nNext;
        int nPrevious = nMaxLen - 1;
        while (nNext != 0) {
            if (nIndex == nNext) {
                m_slArray[nPrevious].nNext = m_slArray[nNext].nNext;
                m_slArray[nNext].data = 0;
                break;
            }
            nPrevious = nNext;
            nNext = m_slArray[nNext].nNext;
        }
        if (nNext == 0)
            return;

        // add to free list
        nNext = m_slArray[0].nNext;
        m_slArray[nIndex].nNext = nNext;
        m_slArray[nIndex].data = 0;
        m_slArray[0].nNext = nIndex;
        nCount--;
    }

    public:
        StaticList(): m_slArray{0} {}
        StaticList( int nMaxLen ): m_slArray{nMaxLen, {0,0}} {
            for (int i = 0; i < nMaxLen; i++) {
                m_slArray.at(i) = StaticListItem{0, i+1};
            }
            m_slArray[nMaxLen - 2].nNext = 0;
            m_slArray[nMaxLen - 1].nNext = 0;
            this->nMaxLen = nMaxLen;
        }

        void insert( StaticListItem & item ) {
            int nAvailable = malloc_sl();
            if (nAvailable != 0) {
                m_slArray[nAvailable].data = item.data;
            }
        }

        StaticListItem remove(int nDataTBR) {
            int nNext = m_slArray[nMaxLen - 1].nNext;
            while (nNext != 0) {
                int nData = m_slArray[nNext].data;
                if (nData == nDataTBR) {
                    free_sl(nNext);
                    break;
                }
                nNext = m_slArray[nNext].nNext;
            }

            // return the value of removed item
            StaticListItem item;
            item.data = 0;
            item.nNext = 0;
            if (nNext != 0) {
                item.data = nDataTBR;
            }
            return item;
        }

        void print() {
            cout << "The current count of items in list is: " << nCount << endl;
            for (auto item : m_slArray) {
                cout << "item.data=" << item.data << " item.nNext=" << item.nNext << endl;
            }
        }
};

int main( void ) {
    cout << "after initializaton:" << endl;
    StaticList sl {10};
    sl.print();

    cout << "After insert data:" << endl;
    StaticListItem item1 {60, 0};
    for (int i = 0; i < 8; i ++) {
        sl.insert(item1);
        item1.data = 61+i;
    }
    sl.print();

    cout << "After remove 62:" << endl;
    sl.remove(62);
    sl.print();

    cout << "After insert 70:" << endl;
    item1 = {70, 0};
    sl.insert(item1);
    sl.print();
}