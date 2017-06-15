template<typename t, typename u> int bit_copy(t& a, u& b)
{
	static_assert(sizeof(b) == sizeof(a), "The parameters of bit_copy must have same width.");
};

static_assert(sizeof(int)==8, "This 64-bit machine should follow this!");

// this file should be compiled with g++ -std=c++11
int main()
{
	return 0;
}
