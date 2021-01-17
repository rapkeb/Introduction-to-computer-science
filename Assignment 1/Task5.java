// You may not change or erase any of the lines and comments 
// in this file. You may only add lines in the designated 
// area.

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args){
 

            // ----------------- "A": write your code BELOW this line only --------
            // your code here (add lines)
	Scanner myScanner = new Scanner(System.in);
	int a = myScanner.nextInt();
	int b = myScanner.nextInt();
	int c = myScanner.nextInt();
	int d = myScanner.nextInt();
	int e = myScanner.nextInt();
	if (a>b)
	{ int tmp = b;
	   b = a;
	   a = tmp; } 
	if (d>e)
	{ int tmp = e;  
	   e = d;  
	   d = tmp; } 
	if (a>d)
 	{ int tmp = d;
	   d = a;
	   a = tmp; } 
	if (b>e)
	{ int tmp = e;
	   e = b;
	   b = tmp; } 
	if (a>c) 
	{ int tmp = c;
	   c = a;
	   a = tmp; } 
	if (c>e)
	{ int tmp = e;
	   e = c;
	   c = tmp; } 
			System.out.println(a);  //min
			System.out.println(e);  //max
            // ----------------- "B" write your code ABOVE this line only ---------

       

    } // end of main
} //end of class Task5

