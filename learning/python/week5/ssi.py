#!/usr/bin/env

from turtle import *

NUMBERS = { 0:(1, 1, 1, 1, 1, 1, 0),
            1:(0, 1, 1, 0, 0, 0, 0),
            2:(1, 1, 0, 1, 1, 0, 1),
            3:(1, 1, 1, 1, 0, 0, 1),
            4:(0, 1, 1, 0, 0, 1, 1),
            5:(1, 0, 1, 1, 0, 1, 1),
            6:(1, 0, 1, 1, 1, 1, 1),
            7:(1, 1, 1, 0, 0, 0, 0),
            8:(1, 1, 1, 1, 1, 1, 1),
            9:(1, 1, 1, 1, 0, 1, 1) }

LINELEN = 20

def drawNumber(switches):
    setheading(0)
    penup()
    if switches[0] == 1:
        pendown()
    forward(LINELEN)

    right(90)

    penup()
    if switches[1] == 1:
        pendown()
    forward(LINELEN)

    penup()
    if switches[2] == 1:
        pendown()
    forward(LINELEN)

    right(90)

    penup()
    if switches[3] == 1:
        pendown()
    forward(LINELEN)

    right(90)

    penup()
    if switches[4] == 1:
        pendown()
    forward(LINELEN)

    penup()
    if switches[5] == 1:
        pendown()
    forward(LINELEN)
   
    penup()
    backward(LINELEN)
    right(90)
    if switches[6] == 1:
        pendown()
    forward(LINELEN)

def ssi(number, numcolor, coordinate):
    penup()
    goto(coordinate)
    color(numcolor)
    pensize(1)
    drawNumber(NUMBERS[number])

def main():
    screensize(60*LINELEN, 30*LINELEN)
    ssi(2,"red",(0,0))
    ssi(0,"red",(2*LINELEN,0))
    ssi(1,"red",(4*LINELEN,0))
    ssi(6,"red",(6*LINELEN,0))
    penup()
    goto(8*LINELEN,-LINELEN)
    write("年")
    ssi(0,"blue",(10*LINELEN,0))
    ssi(9,"blue",(12*LINELEN,0))
    penup()
    goto(14*LINELEN,-LINELEN)
    write("月")
    ssi(2,"pink",(16*LINELEN,0))
    ssi(5,"yellow",(18*LINELEN,0))
    penup()
    goto(20*LINELEN,-LINELEN)
    write("日")

    penup()
    goto(100,100)
    done()

if __name__ == "__main__":
    main()
