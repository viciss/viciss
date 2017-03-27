
def main():
	count = eval(input())
	inputList = input().split(' ')
	dataList = list(map(lambda x: int(x), inputList))

	if count != len(dataList):
		return

	total = 0
	maxTotal = 0
	indexI = -1
	lastIndexI = -1
	indexJ = -1
	maxseq = {}
	previousIsZero = False
	for i in range(count):
		if total == 0 and previousIsZero == False:
			indexI = i

		if dataList[i] == 0:
			previousIsZero = True
		else:
			previousIsZero = False

		total += dataList[i]
		if total >= maxTotal:
			maxTotal = total
			indexJ = i
			if dataList[i] != 0 or lastIndexI == -1:
				lastIndexI = indexI
			if lastIndexI != -1:
				maxseq[lastIndexI] = indexJ
		elif total < 0:
			total = 0

	if maxTotal == 0:
		if len(maxseq) == 0:
			lastIndexI = 0
			indexJ = len(dataList) - 1
		else:
			lastIndexI = min(list(maxseq.keys()))
			indexJ = maxseq[lastIndexI]
	else:
		lastIndexI = min(list(maxseq.keys()))
		indexJ = maxseq[lastIndexI]


	print("{} {} {}".format(maxTotal, dataList[lastIndexI], dataList[indexJ]))

if __name__ == '__main__':
	main()