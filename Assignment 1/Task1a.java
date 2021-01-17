import java.util.Scanner;

public class Task1a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
           
	Scanner myScanner = new Scanner(System.in);
	int firstNum = myScanner.nextInt();
	int secondNum = myScanner.nextInt();
              int thirdNum = myScanner.nextInt();
              int x = 0;
              if ((thirdNum >= secondNum) & (secondNum >= firstNum) & (firstNum >=0))
				x++;
              if ((firstNum * firstNum + secondNum * secondNum == thirdNum * thirdNum) & (x ==1))
           			System.out.println("yes");
              else
           			System.out.println("no");

            // ----------------- write your code ABOVE this line only ---------
		
	}
}
