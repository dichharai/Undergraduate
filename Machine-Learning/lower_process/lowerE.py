#!/usr/bin/python3

import cImage
import csv
comma = ","
for j in range(1,200):
	E = []
	f = cImage.FileImage("training/lower/E/"+str(j)+".gif")        
	for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
			E.append(str(s))
	E.append('E')
	print(comma.join(E))
