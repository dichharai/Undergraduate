import cImage
import csv
comma = ","
for j in range(1,200):
        T = []
        f = cImage.FileImage("training/lower/T/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        T.append(str(s))
        T.append('T')
        print(comma.join(T))
