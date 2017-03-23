counter = input("请输入一个正整数：")

total = 0
for x in range(1,int(counter)+1):
	print("for循环中的x值为：{}".format(x))
	total += x

print("从1加到{}的和为:{}".format(counter, total))