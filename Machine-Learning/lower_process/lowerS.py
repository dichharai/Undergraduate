import cImage
import csv
comma = ","
for j in range(1,200):
        S = []
        f = cImage.FileImage("training/lower/S/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        S.append(str(s))
        S.append('S')
        print(comma.join(S))
