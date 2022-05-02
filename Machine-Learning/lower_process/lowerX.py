#!/usr/bin/python3
import cImage
import csv
comma = ","
for j in range(1,200):
        X = []
        f = cImage.FileImage("training/lower/X/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        X.append(str(s))
        X.append('X')
        print(comma.join(X))
