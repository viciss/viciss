#!/bin/python3

val = input("Please input temperature(For example: 32C): ")
if val[-1] in ['C', 'c']:
	f = 1.8 * float(val[0:-1]) + 32
	print("The converted temperature is: %.2fF"%f)
elif val[-1] in ['F', 'f']:
	c = (float(val[0:-1]) - 32) / 1.8
	print("The converted temperature is: %.2fC"%c)
else:
	print("Input error")
