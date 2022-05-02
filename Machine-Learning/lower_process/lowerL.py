import cImage
import csv
comma = ","
for j in range(1,200):
        L = []
        f = cImage.FileImage("training/lower/L/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        L.append(str(s))
        L.append('L')
        print(comma.join(L))
