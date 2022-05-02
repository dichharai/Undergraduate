#!/usr/bin/python3
import cImage
import csv
comma = ","
for j in range(1,200):
        G = []
        f = cImage.FileImage("training/lower/G/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        G.append(str(s))
        G.append('G')
        print(comma.join(G))
