#!/usr/bin/python3
import cImage
import csv
comma = ","
for j in range(1,200):
        R = []
        f = cImage.FileImage("training/lower/R/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        R.append(str(s))
        R.append('R')
        print(comma.join(R))
