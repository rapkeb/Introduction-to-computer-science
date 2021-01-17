
public class Bit {
	
	private boolean value;

    public Bit(boolean value) {
		this.value = value;
	}

    public String toString() {
    	if(value)
    		return "1";
    	return "0";
    }

    public boolean isOne() {
		return value;
    }

    public boolean lessThan(Bit digit) {
    	if(digit.isOne() & !(this.value))
    		return true;
    	return false;
	}

    public boolean lessEq(Bit digit) {
    	if(!(digit.isOne()) & (this.value))
    		return false;
    	return true;
	}

   public static Bit fullAdderSum(Bit A, Bit B, Bit Cin) {
	   if((A.isOne() & B.isOne() & Cin.isOne()) | 
			   (A.isOne() & !(B.isOne()) & !(Cin.isOne())) |
			   		(!(A.isOne()) & B.isOne() & !(Cin.isOne())) |
			   			(!(A.isOne()) & !(B.isOne()) & Cin.isOne()))
			   					return (new Bit(true));
       return (new Bit(false));
   }
   public static Bit fullAdderCarry(Bit A, Bit B, Bit Cin) {
	   if((A.isOne() & B.isOne() & Cin.isOne()) | 
			   (A.isOne() & (B.isOne()) & !(Cin.isOne())) |
			   		(!(A.isOne()) & B.isOne() & (Cin.isOne())) |
			   			((A.isOne()) & !(B.isOne()) & Cin.isOne()))
			   					return (new Bit(true));
	   return (new Bit(false)); 
   }

}
