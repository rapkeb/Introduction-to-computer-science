import java.util.Scanner;

public class Task3 {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            	Scanner myScanner = new Scanner(System.in);
            	int x = myScanner.nextInt();
	int count=0;
	int flag =0;
            	int i = 2;
            	while(i <= x)
           	{
            	if(x%i == 0)
            	{
		count++;	    //counter for the specific number	
            		x = x / i ;
		flag=1;       //kind of boolean, 1 is true, 0 is false      
             	} 
	else 
	{
		if(flag==1) {
			if(count == 1)
			{System.out.println(i);}
			else
			{System.out.println(i + " " + count);}
			count=0;
			flag=0;   //reset him
			   }
             		i = i + 1 ;	
	
	}
            	}
	if(count == 1)
			{System.out.println(i);}
	else
			{System.out.println(i + " " + count);}
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
