/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019  
---------------------------------------*/
import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;
   
	//Complete the following method
    public PrimeIterator(){
    	this.primes = new LinkedList<Integer>();
    	this.primes.add(2);
    }

	//Complete the following method
    public boolean hasNext(){
    	return true;
    }

	//Complete the following method
    public Integer next(){
    	Integer num = this.primes.get(this.primes.size()-1);
    	primes.add(PrimeNum(num));
        return num; 
    }
    
    private Integer PrimeNum(Integer num){
    	Integer num1 = num;
    	boolean found = false;
    	while(!found){
    		num1 = num1 + 1;
    		if(IsPrime(num1))//checking the next number
    			found = true;
    	}
    	return num1;
    }
    
    private boolean IsPrime(Integer num){//checking if number is prime
    	for(int i = 2; i * i <= num; i = i+1){
    		if(num%i == 0)
    			return false;
    	}
    	return true;
    }
	//DO NOT REMOVE OR CHANGE THIS MEHTOD – IT IS REQUIRED 
	public void remove() {
		return;
	}


}
