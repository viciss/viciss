#include <memory>
#include <iostream>
using namespace std;

template<typename T> struct Item {
    shared_ptr<Item<T>> pNext;
    T data;
};

template<typename T> using QueueItem = Item<T>;

class LinkQueue {
    shared_ptr<QueueItem<int>> m_spHead { nullptr };
    shared_ptr<QueueItem<int>> m_spTail { nullptr };
    int m_nQueueSize { 0 };

    public:
        LinkQueue() : m_nQueueSize{ 0 } {
            m_spHead = shared_ptr<QueueItem<int>>(new QueueItem<int>());
            m_spHead->pNext = nullptr;
            m_spHead->data = -1;
            m_spTail = m_spHead;
        };

        int getQueueSize() {
            return m_nQueueSize;
        };

        void Enqueue( int item ) {
            shared_ptr<QueueItem<int>> temp {new QueueItem<int>()};
            temp->pNext = nullptr;
            temp->data = item;

            m_spTail->pNext = temp;
            m_spTail = temp;
            m_nQueueSize++;
        };

        int Dequeue() {
            shared_ptr<QueueItem<int>> temp = m_spHead->pNext;
            if ( temp == nullptr )
                return -1;
            
            if ( m_nQueueSize == 1 ) {
                m_spTail = m_spHead;
            }
            m_spHead->pNext = temp->pNext;
            
            int nRet = temp->data;
            temp.reset();
            cout << "The use cout for pNext is: " << temp.use_count() << endl;
            m_nQueueSize--;
            return nRet;
        };

        void print() {
            shared_ptr<QueueItem<int>> temp = m_spHead;
            cout << "The linked queue is" << "(" << m_nQueueSize << "): " << endl;
            while ( temp ) {
                cout << temp->data << ":(" << temp.use_count() << ")" << ", ";
                temp = temp->pNext;
            }
            cout << endl;
        };

        ~LinkQueue() {
            while ( Dequeue() != -1 );
        };
};

int main( void ) {
    LinkQueue myQueue;

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
    return 0;
}