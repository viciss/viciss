
def main():
	count = eval(input())
	inputList = input().split(' ')
	dataList = list(map(lambda x: int(x), inputList))

	if count != len(dataList):
		return

	total = 0
	maxTotal = 0
	indexI = 0
	lastIndexI = 0
	indexJ = 0
	maxseq = {}
	for i in range(0,count):
		total += dataList[i]
		if total < 0:
			total = 0
			lastIndexI = i + 1
		else:
			if total > maxTotal:
				maxTotal = total
				indexI = lastIndexI
				indexJ = i
				maxseq[indexI] = indexJ
			elif total == maxTotal and indexI != lastIndexI:
				indexI = lastIndexI
				indexJ = i
				maxseq[indexI] = indexJ
#		print("total={}, maxTotal={}, dataList[{}]={}, indexI={}, indexJ={}, lastIndexI={}, maxseq={}".format(total, maxTotal, i, dataList[i], indexI, indexJ, lastIndexI, maxseq))

	if maxTotal == 0:
		if len(maxseq) == 0:
			indexI = 0
			indexJ = len(dataList) - 1
		else:
			indexI = min(list(maxseq.keys()))
			indexJ = maxseq[indexI]
	else:
		indexI = min(list(maxseq.keys()))
		indexJ = maxseq[indexI]


	print("{} {} {}".format(maxTotal, dataList[indexI], dataList[indexJ]))

if __name__ == '__main__':
	main()