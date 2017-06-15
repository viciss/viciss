while (True):
	try:
		weight, height=eval(input("请输入你的体重(kg)，身高(m):"))
		if weight > 0.0 and height > 0.0:
			break
		else:
			print("请输入正确的体重身高！")
	except TypeError:
		print("请输入正确的体重身高！")
		continue

bmi=weight/height**2.0;
print("你的体重，身高和BMI指数为：{:.2f}(kg), {:.2f}(m), {:.2f}".format(weight, height, bmi))


if bmi < 18.5:
	print("你的体型为偏瘦！")
elif bmi < 24.0:
	print("你的体型为正常！")
elif bmi < 25.0:
	print("根据国标你的体型为偏胖！")
	print("根据国际标准你的体型为正常！")
elif bmi < 28.0:
	print("你的体型为偏胖！")
elif bmi < 30.0:
	print("根据国标你的体型为肥胖！")
	print("根据国际标准你的体型为偏胖！")
else:
	print("你的提醒为肥胖！")
