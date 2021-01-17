/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019 
---------------------------------------*/
import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

    private BankAccountsBinarySearchTree bankAccountsTree;
    private BankAccount current;
    private StackAsDynamicArray<BankAccount> stock;//helping field

    //Complete the following method
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree) {
    	this.bankAccountsTree = bankAccountsTree;
    	this.current = bankAccountsTree.root.data;
    	this.stock  = new StackAsDynamicArray<BankAccount>();
    	fillup();//helping function
    }

    //Complete the following method
    @Override
    public boolean hasNext() {
    	return (!stock.isEmpty());
    }

    //Complete the following method
    @Override
    public BankAccount next() {
    	if(stock.isEmpty())
    	throw new NoSuchElementException();
    return stock.pop();//take the first element of the stack
    }
    
    private void fillup(){
    	StackAsDynamicArray<BankAccount> stack = new StackAsDynamicArray<>(); 
    	BinaryTreeInOrderIterator iter = new BinaryTreeInOrderIterator(this.bankAccountsTree.root);
    	while(iter.hasNext()){
    		BankAccount b = (BankAccount)iter.next();
    		if(b.getBalance() > 100)
    			stack.push(b);
    	}
    	while(!stack.isEmpty()){
    		stock.push(stack.pop());
    	}
    }

    //Do not change this method.
    public void remove() {
        return;
    }
}
