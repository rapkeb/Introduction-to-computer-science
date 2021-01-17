import java.util.Iterator;

public class Number implements Comparable<Number> {
    private static final int BASE = 2;
    private static final Number ZERO = new Number();
    private static final Number ONE = new Number(1);
    private List<Bit> list;
	
    /**
     * Constructs a new Number defaulted to the value zero.
     */
    public Number(){
        list = new LinkedList<Bit>();
        list.add(new Bit(false));
    }

    /**
     * Constructs a new Number from an int.
     * @param number an int representing a decimal number
     */
    public Number(int number){  // assignment #1
        if(number<0)
            throw new IllegalArgumentException("");
        list = new LinkedList<Bit>();
        if(number==0)
            list.add(new Bit(false));
        int remember;
        while (number != 0){
            remember = number % BASE;
            number = number / BASE;
            if(remember==0)
                list.add(new Bit(false));
            else
                list.add(new Bit(true));
        }
    }

    /**
     * Constructs a new Number from a String.
     * @param s a String (possibly) representing a decimal number.
     */
    public Number(String s){    // assignment #2
        this(change(s));//build the function with the int builder
    }
    private static int change (String s){//function that casting from string to int
        int num=0;
        int numeral;
        int power=1;
        if(!isLegal(s))
            throw new IllegalArgumentException("");
        for (int i=s.length()-1;i>=0;i=i-1){
            numeral=s.charAt(i)-'0';
            numeral=numeral*power;
            num = num + numeral;
            power=power*10;
        }
        return num;
    }

    /**
     * Constructs a new Number which is a deep copy of the provided Number.
     * @param number a Number to be copied
     */
    public Number(Number number){ // assignment #3
        list = new LinkedList<Bit>();
        Iterator<Bit> iter= number.bitIterator();
        while (iter.hasNext())//copy each Bit
            this.list.add(iter.next());
    }

    /**
     * Checks if this Number is zero.
     * @return true if and only if this object representing the number zero.
     */
    public boolean isZero(){ // assignment #4
        if((this.list.contains(new Bit(false))) & this.list.size()==1)
            return true;
        return false;
    }


    /**
     * Returns an iterator over the Bit objects in the representation of this number,
     * which iterates over the Bit objects from LSB (first) to MSB (last).
     * @return a LSB-first iterator over the Bit objects in the representation of this number.
     */
    public Iterator<Bit> bitIterator(){ // assignment #5
        return list.iterator();
    }

    /**
     * Adds 1 to the number
     */
    public void increment(){ // assignment #6
        Number num=ONE;//build new Number presenting the Bit 1
        Number momentary = add(num,this);//using function that knows to add
        this.list=momentary.list;
    }


    /**
     * Checks if a provided String represent a legal decimal number.
     * @param s a String that possibly represents a decimal number, whose legality to be checked.
     * @return true if and only if the provided String is a legal decimal number
     */
    public static boolean isLegal(String s){ // assignment #7
        if (s==null)
            return false;
        if((s.length()==0)||((s.charAt(0)=='0')&(s.length()>1)))
            return false;
        for (int i=s.length()-1;i>=0;i=i-1){//checking that all the chars are numbers
            if((s.charAt(i)<'0')|(s.charAt(i)>'9'))
                return false;
        }
        return true;
    }


    /**
     * Compares the specified object with this Number for equality.
     * Returns true if and only if the specified object is also a
     * Number (object) which represents the same number.
     * @param obj he object to be compared for equality with this Number
     * @return true if and only if the specified object is equal to this object
     */
    public boolean equals(Object obj){ // assignment #8
        if(!(obj instanceof Number))
            return false;
        Iterator<Bit> iterObject =((Number) obj).bitIterator();
        Iterator<Bit> iterOur =this.bitIterator();
        if(((Number) obj).list.size()!= this.list.size())
            return false;
        while (iterObject.hasNext()){
            if(!iterOur.next().equals(iterObject.next()))
                return false;
        }
        return true;
    }


    /**
     * Returns a string representation of this Number
     * as a binary number.
     * @return a string representation of this Number
     */
    public String toString(){ // assignment #9
        Iterator<Bit> iterOur =this.bitIterator();
        String s="";
        while (iterOur.hasNext()){
            if(iterOur.next().isZero())
                s=s+"0";
            else
                s=s+"1";
        }
        return revers(s);
    }

    private static String revers(String s){//helping function knows to change the string
        String back="";
        for (int i=s.length()-1;i>=0;i=i-1)
            back=back+s.charAt(i);
        return back;
    }

    private static boolean Smaller (Number num1, Number num2,boolean number){
    	if(num1==null|num2==null)
            throw new IllegalArgumentException("");
    	boolean num = number;
        Iterator<Bit> first =num1.bitIterator();
        Iterator<Bit> second =num2.bitIterator();
        while(first.hasNext()&second.hasNext()){
            Bit b1=first.next();
            Bit b2=second.next();
            if (b1.isZero() & b2.isOne()) {//checking the last char accepts the value 0
                num = true;
            }
            else{
                if (b1.isOne() & b2.isZero()) {
                    num = false;
                }
            }
        }
        if (!first.hasNext()&second.hasNext())
            return true;
        if (first.hasNext()&!second.hasNext())
            return false;
        return num;
    }
    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is less than or equal to the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is less than
     * or equal to the second parameter, as numbers.
     */
    public static boolean lessEq(Number num1, Number num2){ // assignment #10
        if (num1 == null || num2 == null)
        	throw new IllegalArgumentException();
    	return (Smaller(num1,num2,true));
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is strictly less than the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is strictly
     * less than the second parameter, as numbers.
     */
    public static boolean lessThan(Number num1, Number num2){ // assignment #11
    	if (num1 == null || num2 == null)
        	throw new IllegalArgumentException();
    	return (Smaller(num1,num2,false));
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Number o){ // assignment #12
        if(o==null)
            throw new IllegalArgumentException("");
        if(lessThan(this,o))
            return -1;
        if(this.equals(o))
            return 0;
        return 1;
    }


    /**
     * Adds the specified Number objects, and returns their sum.
     * @param num1 the first addend
     * @param num2 the second addend
     * @return the sum of the specified Number objects.
     */
    public static Number add(Number num1, Number num2){ // assignment #13
    	if (num1 == null || num2 == null)
        	throw new IllegalArgumentException();
    	Number total = new Number();
        total.list.remove(new Bit());//making total totally empty
        Bit carry =new Bit(false);
        Iterator<Bit> iternum1=num1.bitIterator();
        Iterator<Bit> iternum2=num2.bitIterator();
        while (iternum1.hasNext()&iternum2.hasNext()) {
            Bit a = iternum1.next();
            Bit b = iternum2.next();
            total.list.add(Bit.fullAdderSum(a, b, carry));
            carry = Bit.fullAdderCarry(a, b, carry);// *saving the carry for the next time entering the loop
        }
        while (iternum1.hasNext()&!iternum2.hasNext()) {
            Bit a = iternum1.next();
            total.list.add(Bit.fullAdderSum(a, new Bit(), carry));
            carry = Bit.fullAdderCarry(a, new Bit(), carry);//same as *
        }
        while (!iternum1.hasNext()&iternum2.hasNext()) {
            Bit b = iternum2.next();
            total.list.add(Bit.fullAdderSum(new Bit(), b, carry));
            carry = Bit.fullAdderCarry(new Bit(),b, carry);//same as *
        }
        if(carry.isOne())
            total.list.add(new Bit(true));//if remains 1 on the carry add him to the list
        return total;
    }


    /**
     * Multiply the specified Number objects, and returns their product.
     * @param num1 the first factor
     * @param num2 the second factor
     * @return the product of the specified Number objects.
     */
    public static Number multiply(Number num1, Number num2){ // assignment #14
    	if (num1 == null || num2 == null)
        	throw new IllegalArgumentException();
    	int count=-1;
        Number Double= ZERO;
        Number temp;
        Iterator<Bit> iternum;
        if(num1.list.size()<=num2.list.size()) {//taking the smaller list for the Iterator
            temp = new Number(num2);
            iternum = num1.bitIterator();
        }
        else{
            temp = new Number(num1);
            iternum = num2.bitIterator();
        }
        while (iternum.hasNext()){
            count=count+1;
            Bit a = iternum.next();
            if(a.isOne()) {
                for (int i = 0; i < count; i = i + 1)
                    temp = ZeroAdding(temp);
                Double = add(Double, temp);
                count=0;//if the Bit is 0 applying the count to start again from 0
            }
        }
        return Double;
    }
    private static Number ZeroAdding(Number num){//helping function adding zero to the list
        Number temp = ZERO;
        Iterator<Bit> iter=num.bitIterator();
        while (iter.hasNext()){
            temp.list.add(iter.next());
        }
        return temp;
    }
}