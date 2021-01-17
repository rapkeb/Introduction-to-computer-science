/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019 
---------------------------------------*/
public class TestPrimeIterator {

	public static void main(String[] args) {
		PrimeIterator iter = new PrimeIterator();
		for (int i = 1; i < 21; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
	}

}
