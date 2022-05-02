import cImage
import csv
comma = ","
for j in range(1,11):
        J = []
        f = cImage.FileImage("training/lower/J/"+str(j)+".gif")
        for row in range(f.getHeight()):
                for col in range(f.getWidth()):
                        p = f.getPixel(col,row)
                        s = (p.getRed()+p.getGreen()+p.getBlue())//3
                        J.append(str(s))
        J.append('J')
        print(comma.join(J))
