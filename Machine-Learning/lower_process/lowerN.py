import cImage
import csv
comma = ","
for j in range(1,200):
        N = []
        f = cImage.FileImage("training/lower/N/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        N.append(str(s))
        N.append('N')
        print(comma.join(N))
