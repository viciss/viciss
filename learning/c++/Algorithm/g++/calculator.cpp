#include <iostream>
#include <vector>
#include <string>
using namespace std;

class my_stack {
    vector<char> m_stArray { 0 };
    int m_nTop { -1 };

    public:
        my_stack() : m_stArray { 0 } {};
        my_stack(size_t nSize) : m_stArray(nSize, '\0') {};

        void push( char c ) {
            cout << "push: array capacity is: " << m_stArray.capacity() << endl;
            cout << "push: 1 current top is: " << m_nTop << endl;
            if ( m_nTop >= 0 && m_nTop >= m_stArray.capacity() - 1 )
                return;
            cout << "push: 2 current top is: " << m_nTop << endl;
            m_stArray[++m_nTop] = c;
            cout << "push: 3 current top is: " << m_nTop << endl;
        };

        char pop() {
            cout << "pop: current top is: " << m_nTop << endl;
            if ( m_nTop < 0 )
                return '\0';
            return m_stArray[m_nTop--];
        };

        char peek() {
            if ( m_nTop < 0 )
                return '\0';
            return m_stArray[m_nTop];
        }

        bool isEmpty() {
            if ( m_nTop < 0 )
                return true;
            return false;
        }

        void print() {
            cout << "The stack size is: " << m_stArray.capacity() <<
                " and current top is: " << m_nTop << endl;
            for ( auto item : m_stArray ) {
                cout << item << " ";
            }
            cout << endl;
        };
};

// + - * / ( )
enum class OP: int {
    PLUS, MINUS, MUL, DIV, LEFT, RIGHT, INVALID
};

// The row id for op_priority table is the previous operator
// and the column id for op_priority table is the later operator

// '>' means the operator on the top of the stack has higher priority than 
// the current operator(not in stack yet), and we need to 
// pop the operator on the top of the stack
// '<' means the operator on the top of the stack has lower priority than
// the current operator(not in stack yet) , and we need to push the 
// current operator into the stack
// '=' means popup from the stack and do not output
//
// for example, op_priority[OP::PLUS][OP::MINUS],
// OP::PLUS stands for the operator on the top of the stack, OP::MINUS stands for the
// current operator
constexpr char op_priority[][6] = {
//+    -    *    /    (    )
{'>', '>', '<', '<', '<', '>'}, // +
{'>', '>', '<', '<', '<', '>'}, // -
{'>', '>', '>', '>', '<', '>'}, // *
{'>', '>', '>', '>', '<', '>'}, // /
{'<', '<', '<', '<', '<', '='}, // (
{'>', '>', '>', '>', '\0', '>'} // )
};

char getOp(char current, char top)
{
    auto op = [] ( char ch ) -> OP {
        switch ( ch ) {
            case '+':
                return OP::PLUS;
            case '-':
                return OP::MINUS;
            case '*':
                return OP::MUL;
            case '/':
                return OP::DIV;
            case '(':
                return OP::LEFT;
            case ')':
                return OP::RIGHT;
            default:
                return OP::INVALID;
        }
    };

    cout << "Current op=" << current << ", top op=" << top << endl;
    OP opCur = op( current );
    if ( opCur == OP::INVALID )
        return '\0';
    OP opTop = op( top );
    if ( opTop == OP::INVALID )
        return '\0';
    
    cout << "op priority is: " << op_priority[(int)opTop][(int)opCur] << endl;
    return op_priority[(int)opTop][(int)opCur];
}

string midToBack( const string & mid ) {
    string back {};
    auto stackc = my_stack { 10 };
    for ( auto ch : mid ) {
        stackc.print();
        if ( isdigit( ch ) ) {
            back += ch;
        }
        else {
            if ( stackc.isEmpty() ) {
                stackc.push( ch );
            }
            else {
                auto chTop = stackc.peek();
                auto getCorrectOp = true;
                switch ( getOp( ch, chTop ) ) {
                    case '>': {
                            do {
                                back += chTop;
                                stackc.pop();
                                chTop = stackc.peek();
                                if ( getOp( ch, chTop ) != '>' )
                                    break;
                            } while ( true );
                            if ( getOp( ch, chTop ) == '=' )
                                stackc.pop();
                            else
                                stackc.push( ch );
                            break;
                        }
                    case '<':
                        stackc.push( ch );
                        break;
                    case '=':
                        stackc.pop();
                        break;
                    default:
                        getCorrectOp = false;
                        break;
                }
                if ( getCorrectOp == false )
                    break;
            }
        }
    }
    stackc.print();
    while ( stackc.isEmpty() == false ) {
        back += stackc.pop();
    }

    return back;
}

int main( void )
{
    auto expression = "3+4*2";
    auto exprBack = midToBack( expression );
    cout << "The final expression is:" << endl;
    cout << exprBack << endl;

    expression = "9+(3-1)*3+10/2";
    exprBack = midToBack( expression );
    cout << "The final expression is:" << endl;
    cout << exprBack << endl;
    return 0;
}