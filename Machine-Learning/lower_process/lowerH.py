import cImage
import csv
comma = ","
for j in range(1,200):
        H = []
        f = cImage.FileImage("training/lower/H/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        H.append(str(s))
        H.append('H')
        print(comma.join(H))
