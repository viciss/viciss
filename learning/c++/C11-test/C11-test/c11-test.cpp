#include <iostream>

using namespace std;

const char * hello()
{
	return __func__;
}

const char * world()
{
	return __func__;
}

int main()
{
#ifdef __STDC_HOSTED__
	cout << "Standard Clib: " << __STDC_HOSTED__ << endl;
#endif

#ifdef __STDC__
	cout << "Standard C: " << __STDC__ << endl;
#endif

#ifdef __STDC_VERSION__
	cout << "C Standard version: " << __STDC_VERSION__ << endl;
#endif

#ifdef __STDC_ISO_10646__
	cout << "ISO/IEC " << __STDC_ISO_10646__ << endl;
#endif

	cout << hello() << ", " << world() << endl;
}