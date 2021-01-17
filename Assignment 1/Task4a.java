import java.util.Scanner;

public class Task4a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
       	Scanner myScanner = new Scanner(System.in);
      	int a = myScanner.nextInt();
	int b = myScanner.nextInt();
              int c = myScanner.nextInt();
	int i = 1;
              int gcd = a ;   //setting the gcd as random number among the 3
              while(i < gcd)
              {
              if((a%gcd == 0) & (b%gcd == 0) & (c%gcd == 0))
			i = gcd;
              else
                  		gcd = gcd - 1;
               }
                  		System.out.println(i);
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
