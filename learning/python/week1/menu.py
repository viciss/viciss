food = ("白菜", "黄瓜", "西红柿", "猪肉", "螃蟹")
for x in range(len(food)):
	for y in range(x + 1, len(food)):
		print("{}配{} ".format(food[x], food[y]), end='')
	print('')