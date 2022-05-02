import java.util.Scanner;
public class Square{
	public static void main(String[] args){
		int n;
		double num;
		double guess;
		Scanner myscan = new Scanner(System.in);
		System.out.print("Please enter a number you want to find square root of: ");
		num = myscan.nextDouble();
		System.out.print("Please enter number of times you want guess to be made: ");
		n = myscan.nextInt();
		guess = num/2;
		for (int i=2; i<=n; i++){
			guess = (guess+(num/guess))/2;
			//System.out.println(guess);
	}
	System.out.println("The guessed square is "+ String.format("%.2f",guess));
	double real_sqaure = Math.sqrt(num);
	double diff = real_sqaure - guess;
	System.out.println("The difference is "+ String.format("%.2f",diff));
	}
}