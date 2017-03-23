import turtle

def drawSnake(rad, angle, len, neckrad):
	for i in range(len):
		turtle.pencolor(((i+1)*10)%255,((i+1)*40)%255,((i+1)*70)%255)
		turtle.circle(rad, angle)
		turtle.pencolor((((i+1)*90)%255,((i+1)*60)%255,((i+1)*30)%255))
		turtle.circle(-rad, angle)
	turtle.circle(rad, angle/2)
	turtle.fd(rad)
	turtle.circle(neckrad+1, 180)
	turtle.fd(rad * 2 / 3)

def main():
	turtle.setup(1300, 800, 0, 0)
	pythonsize = 30
	turtle.colormode(255)
	turtle.pensize(pythonsize)
	turtle.seth(-60)
	drawSnake(40, 80, 5, pythonsize/2)
	turtle.done()

main()
