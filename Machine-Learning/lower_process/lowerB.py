#!/usr/bin/python3
import cImage
import csv
comma = ","
for j in range(1,200):
	B = []
        f = cImage.FileImage("training/lower/B/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
			B.append(str(s))
	B.append('B')
	print(comma.join(B))
