#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Pattern {
    string strPattern;
    vector<int> vecNext;

    void generateNext() {
        int i = 1, j = 0;

        cout << strPattern << endl;
        int nStrLength = strPattern.length();
        if ( nStrLength > 0 ) {
            vecNext.reserve( nStrLength );
        }
        else
            return;
        
        cout << strPattern.length() << endl;
        vecNext.push_back( 0 );

        while ( i < nStrLength ) {
            while ( j > 0 && strPattern[i] != strPattern[j] )
                j = vecNext[j - 1];

            if ( strPattern[i] == strPattern[j] ) {
                j++;
            }
            vecNext.push_back( j );
            i++;
        }
    };

    public:
        Pattern( const string & pattern ) : strPattern { pattern } {
            generateNext();
        };
        Pattern( const char * pattern ) : strPattern { pattern } {
            generateNext();
        };

        const vector<int> & getNext() {
            return vecNext;
        };

        int match( const string & str ) {
            int nStrLength = str.length();
            int nPatternLength = strPattern.length();
            int i = 0;
            int j = 0;

            while ( i < nStrLength && j < nPatternLength ) {
                if ( str[i] == strPattern[j] ) {
                    j++;
                }
                else {
                    j = vecNext[j];
                }
                i++;
            }

            if ( j == nPatternLength )
                return i - j;

            return -1;
        };

        void printNext() {
            cout << "The next array size is: " << vecNext.size() << endl;
            for ( auto index : vecNext ) {
                cout << index << " ";
            }
            cout << endl;
        };
};

int main( void ) {
    Pattern p { "abcdex" };
    p.printNext();
    int pos = p.match( "123abcdexbbbb" );
    cout << "The start matching pos is: " << pos << endl;

    Pattern p1 { "abaababaef" };
    p1.printNext();

    return 0;
}