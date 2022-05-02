import cImage
import csv
comma = ","
for j in range(1,200):
        Q = []
        f = cImage.FileImage("training/lower/Q/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        Q.append(str(s))
        Q.append('Q')
        print(comma.join(Q))
