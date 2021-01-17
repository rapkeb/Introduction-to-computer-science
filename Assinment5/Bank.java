/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019 
---------------------------------------*/
public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	public void balance(){
		namesTree.balance();
		accountNumbersTree.balance();
	}
	
	public Object exportNames() {
		return this.namesTree;
	}
	public Object exportAccountNumbers() {
		return this.accountNumbersTree;
	}
	
	// END OF Given code -----------------------------------
	
	//Complete the following method
	public boolean add(BankAccount newAccount) {
		if(lookUp(newAccount.getName()) != null)//
			return false;
		if(lookUp(newAccount.getAccountNumber()) != null)
			return false;
		namesTree.insert(newAccount);
		accountNumbersTree.insert(newAccount);
		return true;
	}

	//Complete the following method
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		if(toRemove == null)
			return false;
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		// complete this:
		return true;	
	}
	
	//Complete the following method
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		if(toRemove == null)
			return false;
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		// complete this:
		return true;	
	}

	//Complete the following method
	public boolean depositMoney(int amount, int accountNumber){
		if(amount < 0)
			return false;
		BankAccount toDeposite = lookUp(accountNumber);
		if(toDeposite != null)
			return toDeposite.depositMoney(amount);
		return false;
	}
	
	//Complete the following method
	public boolean withdrawMoney(int amount, int accountNumber){
		if(amount < 0)
			return false;
		BankAccount withdraw = lookUp(accountNumber);
		if(withdraw != null){
			return withdraw.withdrawMoney(amount);
		}
		return false;
	}
	


}
