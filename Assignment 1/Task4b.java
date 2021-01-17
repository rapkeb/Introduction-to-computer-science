import java.util.Scanner;

public class Task4b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
                      Scanner myScanner = new Scanner(System.in);
                  int a = myScanner.nextInt();
	    int b = myScanner.nextInt();
                  int c = myScanner.nextInt();
                  int i = 1;
                  int lcm = 0;
                  while(i != lcm)
                  {
                  if ((i%a == 0) & (i%b == 0) & (i%c == 0))
                 	 lcm = i;
         	    else
             	    	 i = i + 1;
                  }
                  	System.out.println(lcm);   
         // ----------------- write your code ABOVE this line only ---------
		
	}
}
