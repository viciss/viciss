total = 0
for x in range(1, 11):
	temp = 1
	for y in range(1, x+1):
		temp *= y
	total += temp
	print("{}!".format(x), end='')
	if x!=10:
		print("+", end='')
	else:
		print("=", end='')
print("{}".format(total))

'''
better solution:
total, temp = 0, 1
for x in range(1, 11):
	temp *= x
	total += temp
'''