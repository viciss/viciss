#/bin/python3

dataList=[4,-3,5,-2,-1,6,-2]


def maxSubseq(dataList):
    if dataList.len() <= 0:
        return 0
    else:
        maxSubseq(dataList[0, dataList.len // 2])
    pass

def main():
    maxSubseq(dataList)

main()
