#include <vector>
#include <iostream>
using namespace std;

class WrapQueue {
    vector<int> m_szArray { 0 };
    int m_nFront { 0 };
    int m_nRear { 0 };

    public:
        WrapQueue() {};
        WrapQueue( size_t size ) : m_szArray( size, -1 ) {};

        int GetQueueSize() {
            return ( m_nRear - m_nFront + m_szArray.capacity() ) % m_szArray.capacity();
        }

        void Enqueue( int item ) {
            // if the queue if full
            if ( ( m_nRear + 1 ) % m_szArray.capacity() == m_nFront )
                return;
            m_szArray[m_nRear % m_szArray.capacity()] = item;
            m_nRear = ( m_nRear + 1 ) % m_szArray.capacity();
        }

        int Dequeue() {
            // the queue is empty
            if ( m_nFront == m_nRear )
                return -1;
            int nTemp = m_szArray[m_nFront];
            m_szArray[m_nFront] = -1;
            m_nFront = ( m_nFront + 1 ) % m_szArray.capacity();
            return nTemp;
        }

        void print() {
            cout << "The queue size is: " << GetQueueSize() << endl;
            cout << "The queue is: " << endl;
            for ( auto item : m_szArray ) {
                cout << item << ",";
            }
            cout << endl;
        }
};

int main( void ) {
    WrapQueue myQueue { 10 };
    for ( int i = 0; i < 10; i++ )
        myQueue.Enqueue(100 + i);
    myQueue.print();

    myQueue.Dequeue();
    myQueue.Dequeue();
    myQueue.Dequeue();
    myQueue.print();

    myQueue.Enqueue(200);
    myQueue.Enqueue(201);
    myQueue.print();
}