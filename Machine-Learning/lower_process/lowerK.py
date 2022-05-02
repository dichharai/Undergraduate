import cImage
import csv
comma = ","
for j in range(1,200):
        K = []
        f = cImage.FileImage("training/lower/K/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        K.append(str(s))
        K.append('K')
        print(comma.join(K))
