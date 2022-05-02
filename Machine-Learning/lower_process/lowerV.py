import cImage
import csv
comma = ","
for j in range(1,200):
        V = []
        f = cImage.FileImage("training/lower/V/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        V.append(str(s))
        V.append('V')
        print(comma.join(V))
