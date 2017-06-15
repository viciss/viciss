def main():
	line1 = list(map(lambda x: int(x), input().split()))
	line2 = list(map(lambda x: int(x), input().split()))
	count1 = line1[0]
	count2 = line2[0]

	poly1 = {}
	for i in range(1, len(line1), 2):
		if poly1.get(line1[i+1], 0) == 0:
			poly1[line1[i+1]] = line1[i]
		else:
			poly1[line1[i+1]] += line1[i]
			count1 = count1 - 1
	if count1 != len(poly1):
		return

	poly2 = {}
	for i in range(1, len(line2), 2):
		if poly2.get(line2[i+1], 0) == 0:
			poly2[line2[i+1]] = line2[i]
		else:
			poly2[line2[i+1]] += line2[i]
			count2 = count2 - 1
	if count2 != len(poly2):
		return

#	print("poly1.keys()={}, poly1.values()={}".format(poly1.keys(), poly1.values()))
#	print("poly2.keys()={}, poly2.values()={}".format(poly2.keys(), poly2.values()))

	keyList1 = sorted(poly1.keys(), reverse=True)
	keyList2 = sorted(poly2.keys(), reverse=True)
#	print("sorted key list1={}".format(keyList1))
#	print("sorted key list2={}".format(keyList2))

	polyMul = {}
	for key1 in keyList1:
		for key2 in keyList2:
			temp = poly1[key1] * poly2[key2]
			if polyMul.get(key1 + key2, 0) == 0:
				polyMul[key1 + key2] = temp
			else:
				polyMul[key1 + key2] += temp
				if polyMul[key1 + key2] == 0:
					del polyMul[key1 + key2]

	keyMul = sorted(polyMul.keys(), reverse=True)
	for key in keyMul:
		if key == min(keyMul):
			print("{} {}".format(polyMul[key], key), end="")
		else:
			print("{} {} ".format(polyMul[key], key), end="")
	if len(keyMul) == 0:
		print("0 0", end="")
	print("")

	polyAdd = {}
	for key1 in keyList1:
		polyAdd[key1] = poly1[key1]
		if poly2.get(key1, 0) != 0:
			polyAdd[key1] += poly2[key1]
			del poly2[key1]
		if polyAdd[key1] == 0:
			del polyAdd[key1]
	polyAdd.update(poly2)

	keyAdd = sorted(polyAdd.keys(), reverse=True)
	for key in keyAdd:
		if key == min(keyAdd):
			print("{} {}".format(polyAdd[key], key), end="")
		else:	
			print("{} {} ".format(polyAdd[key], key), end="")
	if len(keyAdd) == 0:
		print("0 0", end="")
	print("")


if __name__ == '__main__':
	main()