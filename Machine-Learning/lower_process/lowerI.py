import cImage
import csv
comma = ","
for j in range(1,7):
        I = []
        f = cImage.FileImage("training/lower/I/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        I.append(str(s))
        I.append('I')
        print(comma.join(I))
