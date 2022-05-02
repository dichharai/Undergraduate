import java.util.Scanner;
import java.lang.Math;
public class Pi{
	public static void main(String[] args){
		double piApprox = 0.0;
		int n;
		double diff;
		Scanner myscan = new Scanner(System.in);
		System.out.print("Please enter a number till where you want pi Approximation: ");
		n = myscan.nextInt();
		for(int i = 0; i<n; i++){
			piApprox = piApprox + Math.pow(-1,i)*((double)4/((2*i)+1));
		}
		System.out.println("The approximation of pi with "+n+" series is "+ String.format("%.2f",piApprox));
		diff = Math.PI -piApprox;
		System.out.println("The difference between approximation and real value of Pi is "+String.format("%.2f",diff));


	}
	
}