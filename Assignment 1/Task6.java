// You may not change or erase any of the lines and comments 
// in this file. You may only add lines.

import java.util.Scanner;

public class Task6 {


    public static void main(String[] args){


            // ----------------- write any code BELOW this line only --------
	int a;
	int b;
	int c;
	int d;
	int e;
	int count = 0 ;
	boolean example = false;
              for(int aNow = 0 ; aNow <= 1 ; aNow ++)
	{
	for(int bNow = 0 ; bNow <= 1 ; bNow ++)
	{
	for(int cNow = 0 ; cNow <= 1 ; cNow ++)
	{
	for(int dNow = 0 ; dNow <= 1 ; dNow ++)
	{
	for(int eNow = 0 ; eNow <= 1 ; eNow ++)
	{
            // ----------------- write any code ABOVE this line only ---------




            // -----------------  copy here the code from Task 5 that is between
            // -----------------  the comments "A" and "B"
	a = aNow;  //set a with the real value i want, same in the next lines
	b = bNow;
	c = cNow;
	d = dNow;
	e = eNow;
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
            // -----------------  end of copied code from Task 5




            // ----------------- write any code BELOW this line only --------
              if((a<=e) & (a<=b) & (a<=c) & (a<=d) & (e>=b) & (e>=c) & (e>=d))   //checking a is min and e is max
             			count++;
	 else
	{
	if(example == false)   //if we didn't print counterexample
		{
			System.out .println(aNow);
			System.out .println(bNow);
			System.out .println(cNow);
			System.out .println(dNow);
			System.out .println(eNow);
			example = true;
		}
	}
	}
	}
	}
	}
	}
	if(count == 32)
			System.out.println("Verified");
            // ----------------- write any code ABOVE this line only ---------

    } // end of main
} //end of class Task6

