#!/usr/bin/python3
import cImage
import csv
comma = ","
for j in range(1,200):
        M = []
        f = cImage.FileImage("training/lower/M/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        M.append(str(s))
        M.append('M')
        print(comma.join(M))
