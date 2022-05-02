#!/usr/bin/python3

import cImage
import csv
c = 0
comma = ","
for j in range(1,200):
	A = []
	f = cImage.FileImage("training/lower/A/"+str(j)+".gif")
	for row in range(f.getHeight()):
		for col in range(f.getWidth()):
			p = f.getPixel(col,row)
			s = (p.getRed()+ p.getGreen()+p.getBlue())//3
			A.append(str(s))
	A.append("A")
	print(comma.join(A))		
                                
                                       

