#!/usr/bin/python3
import cImage
import csv
comma = ","
for j in range(1,200):
	F = []
	f = cImage.FileImage("training/lower/F/"+str(j)+".gif")
	for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                     	p = f.getPixel(col,row)
			s = (p.getRed()+p.getGreen()+p.getBlue())//3
			F.append(str(s))
	F.append('F')
	print(comma.join(F))
