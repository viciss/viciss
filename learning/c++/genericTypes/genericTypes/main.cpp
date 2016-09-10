#include "functionobj.h"
#include <vector>
#include <iostream>
#include <algorithm>

int main(int argc, char * argv[])
{
	using namespace std;
	vector<int> v1;
	vector<int>::iterator Iter1;

	int i;
	for (i = -4; i <= 2; i++)
	{
		v1.push_back(i);
	}

	cout << "Original vector v1 = ( ";
	for (Iter1 = v1.begin(); Iter1 != v1.end(); Iter1++)
	{
		cout << *Iter1 << " ";
	}
	cout << ")." << endl;

	for_each(v1.begin(), v1.end(), MultValue<int>(-2));

	cout << "Multiplying the elements of the vector v1\n "
		<< "by the factor -2 gives:\n v1mod1 = ( ";
	for (Iter1 = v1.begin(); Iter1 != v1.end(); Iter1++)
	{
		cout << *Iter1 << " ";
	}
	cout << ")." << endl;

	for_each(v1.begin(), v1.end(), MultValue<int>(5));
	cout << "Multiplying the elements of the vector v1\n "
		<< "by the factor 5 gives:\n v1mod1 = ( ";
	for (Iter1 = v1.begin(); Iter1 != v1.end(); Iter1++)
	{
		cout << *Iter1 << " ";
	}
	cout << ")." << endl;

	double avemod2 = for_each(v1.begin(), v1.end(), Average());
	cout << "The average of the elements of v1 is: \n Average( v1mod2 ) = "
		<< avemod2 << "." << endl;
	return 0;
}