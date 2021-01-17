/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {
		 if(account1.getAccountNumber()<account2.getAccountNumber())
		      return -1;
		   if(account1.getAccountNumber()==account2.getAccountNumber())
		      return 0;
		   return 1;
		}

}
