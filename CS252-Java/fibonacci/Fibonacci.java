import java.util.Scanner;
public class Fibonacci{
	public static void main(String[] args){
		int n;
		int fib=0;
		int prev = 1;
		int cur = 1;
		Scanner myscan = new Scanner(System.in);
		System.out.print("Please enter a number that you want fibonacci number of: ");
		n = myscan.nextInt();
		if (n==1 || n==2){
			System.out.println(prev);
		}
		else{
			for (int i=3; i<=n; i++ ){
				fib=prev+cur;
				prev=cur;
				cur=fib;
		 }
		 System.out.println(n+"th fibonacci number is "+fib);
		}
	}
}