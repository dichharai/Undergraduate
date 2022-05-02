#!/usr/bin/python3

import cImage
import csv
comma = ","
for j in range(1,200):
	D = []
	f = cImage.FileImage("training/lower/D/"+str(j)+".gif")
	for row in range(f.getHeight()):
		for col in range(f.getWidth()):
			p = f.getPixel(col,row)
			s = (p.getRed()+p.getGreen()+p.getBlue())//3
			D.append(str(s))
	D.append('D')
	print(comma.join(D))
