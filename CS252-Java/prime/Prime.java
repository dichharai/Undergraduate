import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Prime{
	public static void main(String[] args){
		int n;
		Scanner myscan = new Scanner(System.in);
		List<Integer> prime_list = new ArrayList<Integer>();// Dynamic List
		System.out.print("Please enter a number to find whether it is prime or not: ");
		n = myscan.nextInt();
		// First part
		/*double upperL = Math.sqrt(n);
		int i = 2;
		while (i <= upperL ){
			if (n%i == 0){
				System.exit(0);
			}
			else{
				i++;
			}
		}
		System.out.println("The number "+ n +" is prime.");*/
		// every prime number less than or equal to n --IInd part
		if (n==2 || n==3){
			System.out.println(n+" is a prime number.");
		}
		else if (n>3){
			prime_list.add(2);
			prime_list.add(3);
			for (int j=4; j<=n; j++){
				double uL = Math.sqrt(j);
				int c=0;
				for (int k=2; k<=uL;k++){
					if (j%k == 0){
						c++;
					}
				}
				/*if (c>=1){
				System.out.println(j+" is not a prime number");
				}
				else{
				System.out.println(j+" is a prime number");
				}*/
				if (c==0){
					prime_list.add(j);
				}
				
		}
		
		System.out.print("The prime numbers less than or equal to "+n+" are ");
		for (int l=0;l<prime_list.size();l++){
			if (l<(prime_list.size()-1)){
					System.out.print(prime_list.get(l)+ ", ");
			}
			else{
					System.out.print(prime_list.get(l));
			}
		}
		System.out.println();
	}
	//Goldbach Conjecture
	System.out.println("************Goldbach Conjecture************");
	if (n%2 == 0){
		System.out.println(n+" is a an even number");
		for (int m=0; m<prime_list.size(); m++){
			for (int p=1; p<prime_list.size(); p++){
				if (prime_list.get(m)+prime_list.get(p)==n){
					System.out.println("The two prime numbers that adds to "+ n + " are "+ prime_list.get(m)+ " and "+prime_list.get(p));
				}
			}
		}
	}
	}
}