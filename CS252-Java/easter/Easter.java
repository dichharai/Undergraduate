import java.util.Scanner;
public class Easter{
	public static void main(String[] args){
		int a,b,c,d,e;
		int easterY;
		int easterD;
		String month;
		Scanner myscan = new Scanner(System.in);
		System.out.print("Enter a year you want the date of easter: ");
		easterY = myscan.nextInt();
		if (easterY < 1900 || easterY > 2099){
			System.out.println("The algorithm does not work for the year "+easterY);
		}
			else{
				a = easterY%19;
				b = easterY%4;
				c = easterY%7;
				d = ((19*a)+24)%30;
				e = ((2*b)+(4*c)+(6*d)+5)%7;
				easterD = 22+d+e;
				//System.out.println(easterD);
				if (easterY == 1954 || easterY == 1981 || easterY == 2049 || easterY == 2076){
					easterD = easterD - 38; 
					month = "April";
					System.out.println("The date of easter for the year "+easterY+" is "+ month +" "+easterD+".");
				} 
				else if (easterD > 31){
					easterD = easterD - 31;
					month = "April";
					System.out.println("The date of easter for the year "+easterY+" is "+ month +" "+easterD+".");
				}
				else{
					month = "March";
					System.out.println("The date of easter for the year "+easterY+" is "+ month +" "+easterD+".");
				}
			}
	}
}