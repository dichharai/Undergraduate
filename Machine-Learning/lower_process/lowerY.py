#!/usr/bin/python3
import cImage
import csv
comma = ","
for j in range(1,200):
        Y = []
        f = cImage.FileImage("training/lower/Y/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        Y.append(str(s))
        Y.append('Y')
        print(comma.join(Y))
