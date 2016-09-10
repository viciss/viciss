#pragma once
template <class Type>
class MultValue
{
private:
	Type Factor;

public:
	MultValue(const Type & _Val) : Factor(_Val)
	{
	}

	void operator ()(Type & elem) const
	{
		elem *= Factor;
	}
};

class Average
{
private:
	long num;
	long sum;

public:
	Average() : num(0), sum(0)
	{
	}

	void operator () (int elem)
	{
		num++;
		sum += elem;
	}

	operator double()
	{
		return static_cast<double> (sum) / static_cast<double> (num);
	}
};

