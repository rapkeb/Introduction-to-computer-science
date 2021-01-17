/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019  
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {//comparing between 2 strings by the size and the chars they contains
		if(account1.getName().equals(account2.getName()))
		      return 0;
		   else {
		      int i;
		      for (i = 0; i < account1.getName().length() & i < account2.getName().length(); i = i + 1) {
		         if (account1.getName().charAt(i) < account2.getName().charAt(i)) {
		            return -1;
		         }
		         if (account1.getName().charAt(i) > account2.getName().charAt(i)) {
		            return 1;
		         }
		      }
		      if(( i < account1.getName().length()) & !(i < account2.getName().length()))
		         return 1;
		      return -1;
		   }
	}
}
