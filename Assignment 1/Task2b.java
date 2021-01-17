import java.util.Scanner;

public class Task2b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------

            	Scanner myScanner = new Scanner(System.in);
            	int n = myScanner.nextInt();
            	int k = myScanner.nextInt();
            	int r = 0;	     // r it's the rest
            	r = n % k;
            	n-- ;
              while (n>=1)
           	{
		r = (r * n ) % k;
              	n--;
           	}
           		System.out.println(r);

            // ----------------- write your code ABOVE this line only ---------
		
	}
}
