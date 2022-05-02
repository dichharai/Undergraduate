import cImage
import csv
comma = ","
for j in range(1,198):
        P = []
        f = cImage.FileImage("training/lower/P/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        P.append(str(s))
        P.append('P')
        print(comma.join(P))
