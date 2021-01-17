import java.util.Iterator;


public class NumberTester
{
    public static void main(String[] args)
    {
        System.out.println("testNumber() = " + testNumber());
        System.out.println("testIsZero() = " + testIsZero());
        System.out.println("testBitIterator() = " + testBitIterator());
        System.out.println("testIncrement() = " + testIncrement());
        System.out.println("testIsLegal() = " + testIsLegal());
        System.out.println("testEquals() = " + testEquals());
        System.out.println("testToString() = " + testToString());
        System.out.println("testLessEq() = " + testLessEq());
        System.out.println("testLessThan() = " + testLessThan());
        System.out.println("testCompareTo() = " + testCompareTo());
        System.out.println("testAdd() = " + testAdd());
        System.out.println("testMultiply() = " + testMultiply());
    }


    public static boolean testNumber(){
        Number num= new Number(8);
        Number num1= new Number("8");
        Number num2= new Number(num1);
        Number num3= new Number();
        Number num4= new Number("0");
        Number num5= new Number(0);
        Number num6= new Number(num3);
        Number num7= new Number(1);
        Number num8= new Number("1");
        boolean state=num.equals(num1);//true
        boolean state1=num.equals(num2);//true
        boolean state2=num1.equals(num2);//true
        boolean state4=num3.equals(num5);//true
        boolean state5=num3.equals(num6);//true
        boolean state7=num4.equals(num5);//true
        boolean state8=num4.equals(num6);//true
        boolean state9=num5.equals(num6);//true
        boolean state10=num7.equals(num8);//true
        boolean state11=num7.equals(new Bit(true));//false
        return ((state)&(state1)&(state2)&(state4)&(state5)&(state7)&(state8)&(state9)&(state10)&(!state11));
    }


    public static boolean testIsZero(){
        Number num= new Number(35);//false
        Number num1= new Number();//true
        Number num2= new Number(num);//false
        Number num3= new Number(num1);//true
        Number num4= new Number("8");//false
        Number num5= new Number(0);//true
        Number num6= new Number("0");//true
        if((!num.isZero())&(num1.isZero())&(!num2.isZero())&(num3.isZero())&(!num4.isZero())&(num5.isZero())&(num6.isZero()))
            return true;
        return false;
    }

    public static boolean testBitIterator(){
        Number num= new Number(5);
        Number num1= new Number();
        Number num2= new Number(num);
        Number num3= new Number("8");

        Iterator<Bit> iter=num.bitIterator();
        Iterator<Bit> iter1=num1.bitIterator();
        Iterator<Bit> iter2=num2.bitIterator();
        Iterator<Bit> iter3=num3.bitIterator();

        return (((iter.hasNext())&(iter1.hasNext())&(iter2.hasNext())&(iter3.hasNext())) & (iter.next() != iter3.next()));
    }


    public static boolean testIncrement(){
        Number num1= new Number(4);
        Number num = new Number(8);
        num1.increment();
        num1.increment();
        num1.increment();
        num1.increment();

        Number num2= new Number(Integer.MAX_VALUE);
        Number num3= new Number("2147483647");
        num2.increment();
        num2.increment();
        num3.increment();
        num3.increment();
        return num.equals(num1)& num2.equals(num3);
    }


    public static boolean testIsLegal(){
        String s1="";//false
        String s2="-24";//false
        String s3="$#*";//false
        String s4="099";//false
        String s5="00";//false
        String s6="86";//true
        String s7="0";//true
        return ((!Number.isLegal(s1))&(!Number.isLegal(s2))&(!Number.isLegal(s3))&(!Number.isLegal(s4))&(!Number.isLegal(s5))&(Number.isLegal(s6))&(Number.isLegal(s7)));
    }


    public static boolean testEquals(){
        Number num= new Number(89);
        Object num1= new Number(89);
        Number num2= new Number(1);
        Number num3= new Number();
        Number num4= new Number("5");
        Object num6= new Bit();
        Bit bit = new Bit(true);
        boolean state=num.equals(num1);//true
        boolean state1=num.equals(num2);//false
        boolean state2=num.equals(num4);//false
        boolean state3=num2.equals(num6);//false
        boolean state5=num3.equals(num6);//false
        boolean state6=num2.equals(bit);//false
        boolean state7=num1.equals(num);//true
        return (state & !state1 & !state2 & !state3 & !state5 & !state6 & state7);
    }

    public static boolean testToString(){
        Number num = new Number(8);
        String s = num.toString();
        Number num1 = new Number(5);
        String s1 = num1.toString();
        return (s.equals("1000") & (s1.equals("101"))) ;
    }


    public static boolean testLessEq(){
        Number num= new Number(87);
        Number num1= new Number(76);
        Number num2= new Number(3451);
        Number num3= new Number("76");
        Number num4= new Number("77");
        boolean state=Number.lessEq(num,num1);//false
        boolean state1=Number.lessEq(num,num2);//true
        boolean state2=Number.lessEq(num1,num);//true
        boolean state3=Number.lessEq(num1,num2);//true
        boolean state4=Number.lessEq(num,num3);//false
        boolean state5=Number.lessEq(num2,num1);//false
        boolean state6=Number.lessEq(num1,num3);//true
        boolean state7=Number.lessEq(num3,num4);//true
        boolean state8=Number.lessEq(num4,num3);//false
        return ((!state)&(state1)&(state2)&(state3)&(!state4)&(!state5)&(state6)&(state7)&(!state8));
    }


    public static boolean testLessThan(){
        Number num= new Number("4");
        Number num1= new Number(5);
        Number num2= new Number(7);
        Number num3= new Number("134");
        Number num4= new Number(135);
        Number num5= new Number(134);
        boolean state=Number.lessThan(num,num1);//true
        boolean state1=Number.lessThan(num,num2);//true
        boolean state2=Number.lessThan(num1,num);//false
        boolean state3=Number.lessThan(num,num3);//true
        boolean state4=Number.lessThan(num2,num1);//false
        boolean state5=Number.lessThan(new Number(),new Number(1));//true
        boolean state6=Number.lessThan(num4,num3);//false
        boolean state7=Number.lessThan(num5,num3);//false
        boolean state8=Number.lessThan(num2,new Number(7));//false
        return ((state)&(state1)&(!state2)&(state3)&(!state4)&(state5)&(!state6)&(!state7)&(!state8));
    }


    public static boolean testCompareTo(){
        Number num= new Number("2");
        Number num1= new Number(3);
        Number num2= new Number(1);
        int compare=num.compareTo(num1);//-1
        int compare1=num.compareTo(num2);//1
        num2.increment();
        int compare2=num.compareTo(num2);//0
        num2.increment();
        int compare3=num2.compareTo(num1);//0
        return ((compare==-1)&(compare1==1)&(compare2==0)&(compare3==0));
    }


    public static boolean testAdd(){
        Number num= new Number(5);//101
        Number num1 = new Number("5");//101
        Number num2= Number.add(num ,num1);//1010
        Number num3= new Number("7");//11
        Number num4 = new Number(3);//111
        Number num5= Number.add(num3 ,num4);//1010
        Number num6= new Number(5000);
        Number num7 = new Number("687");
        Number num8= Number.add(num6 ,num7);
        return (new Number(10).equals(num2))&(new Number(10).equals(num5))&(new Number(5687).equals(num8));
    }

    public static boolean testMultiply(){
        Number num= new Number(0);//0
        Number num1 = new Number(3);//11
        Number num2= Number.multiply(num ,num1);//0

        Number num3= new Number(14);//1110
        Number num4 = new Number(5);//101
        Number num5= Number.multiply(num4 ,num3);//70-1000110

        Number num6= new Number(2500);//100111000100
        Number num7 = new Number("100");//1100100
        Number num8= Number.multiply(num6 ,num7);//111101000010010000

        return (new Number("0").equals(num2)) & (new Number(70).equals(num5)) & (new Number(250000).equals(num8));
    }
}