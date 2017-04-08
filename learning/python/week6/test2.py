#!/usr/bin/env python3

def main():
    fo = open("test2.txt", "r")
    for line in fo:
        print(line, end="")
    fo.close()

if __name__ == "__main__":
    main()
