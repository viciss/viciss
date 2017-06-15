#!/usr/bin/env python3

def testrb():
    testFile = open("test.txt", "rb")
    for line in testFile:
        print(line)
    testFile.close()

def testrt():
    testFile = open("test.txt", "rt")
    for line in testFile:
        print(line, end="")
    testFile.close()

def main():
    print("test open file with rb")
    testrb()
    print("test open file with rt")
    testrt()

if __name__ == "__main__":
    main()
