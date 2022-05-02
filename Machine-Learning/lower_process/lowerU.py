import cImage
import csv
comma = ","
for j in range(1,200):
        U = []
        f = cImage.FileImage("training/lower/U/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        U.append(str(s))
        U.append('U')
        print(comma.join(U))
