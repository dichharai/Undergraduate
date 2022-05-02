import cImage
import csv
comma = ","
for j in range(1,200):
        O = []
        f = cImage.FileImage("training/lower/O/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        O.append(str(s))
        O.append('O')
        print(comma.join(O))
