for x in range(1, 10):
	for y in range(1, x+1):
		print("{:2}x{:2}={:2}".format(y, x, x*y), end='')
	print('')