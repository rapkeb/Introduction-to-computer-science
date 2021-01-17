import java.util.Scanner;

public class Task2a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------

       	Scanner myScanner = new Scanner(System.in);
       	int N = myScanner.nextInt();
      	int Factorial = 1;
     	int i = 1;
            	while (i <= N)
           	{
            		Factorial = Factorial * i ;     // current i * factorial until now
            		i = i + 1 ;
           	}
            		System.out.println(Factorial);

            // ----------------- write your code ABOVE this line only ---------
		
	}
}
