import java.util.Scanner;
import java.lang.Math;
public class Conversion{
    public static void main(String[] args){
	double tempC;
	double tempF;
	double rectL, rectW, rectD;
	double rectA;
	double radiusS;
	double diagonal;
	double sphereA;
	double surfaceA;
    char tempChoice;
    double temp;
       
	Scanner myscan = new Scanner(System.in);
	System.out.println("************Temperature Conversion************");
        System.out.print("Please enter F or C to convert temperature to: ");
        tempChoice = myscan.next(".").charAt(0);//no methods nextChar(),
   
	if (tempChoice == 'C' || tempChoice == 'c'){
	    System.out.print("Please enter the temperature in Fahrenheit :");
	    temp = myscan.nextDouble();
	    tempC = ((double)5/(double)9)*(temp-32);
	    System.out.println("The temperature in Celcius is "+ String.format("%.2f",tempC));
	} 
	else if (tempChoice =='F' || tempChoice =='f'){
	    System.out.print("Please enter the temperature in Celcius: ");
	    temp = myscan.nextDouble();
	    tempF = ((double)9/(double)5)*temp+32;
	    System.out.println("The temperature in fahrenheit is "+ String.format("%.2f",tempF));
	}
	else {
	    System.out.println("You did not put the correct conversion type.");
	}
	System.out.println();
	System.out.println("************Area of Rectangle************");
	System.out.print("Please enter length of a rectangle: ");
	rectL = myscan.nextDouble();	
	System.out.print("Please enter width of a rectangle: ");
	rectW = myscan.nextDouble();
	rectA = rectL*rectW;
	System.out.println("The area of the rectangle is: "+ String.format("%.2f",rectA));
	rectD=Math.sqrt(Math.pow(rectL,2)+Math.pow(rectW,2));
	System.out.println("The diagonal of the rectangle is: "+String.format("%.2f",rectD));
	System.out.println();
	System.out.println("************Volume and Surface area of Sphere************");
	System.out.print("Please enter raidus of a sphere: ");
	radiusS= myscan.nextDouble();
	sphereA = ((double)4/(double)3)*Math.PI*Math.pow(radiusS,3);
	System.out.println("The volume of a sphere is "+ String.format("%.2f",sphereA));
	surfaceA = 4*Math.PI*Math.pow(radiusS,2);
	System.out.println("The surface area of a sphere is "+ String.format("%.2f",surfaceA));

    }


}
        
	
       
