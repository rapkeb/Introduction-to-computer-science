import java.util.Scanner;

public class Task4c {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            Scanner myScanner = new Scanner(System.in);
            int a = myScanner.nextInt();
            int b = myScanner.nextInt();
            int c = myScanner.nextInt();
            int d = myScanner.nextInt();
            int e = myScanner.nextInt();
            int f = myScanner.nextInt();
            int x = b * d * f;   //common denominator
            if((a*d*f) + (c*b*f) + (e*b*d) == x)
            		System.out.println("yes");
            else
            		System.out.println("no");
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
