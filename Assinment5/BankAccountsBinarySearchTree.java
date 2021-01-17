/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019 
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	//Complete the following method
	public void balance(){
		BankAccountsBinarySearchTree tree = new BankAccountsBinarySearchTree(comparator);
		List <BankAccount> list = new LinkedList<>();
		Iterator<BankAccount> iter = new BinaryTreeInOrderIterator<>(root);
		while(iter.hasNext()){
			list.add(iter.next());//adding to the list
		}
		int low = 0;
		int high = list.size() - 1;
		buildBalancedTree(tree,list,low,high);//send the variables to the helping function
		this.root = tree.root;
	}
	
	//Complete the following method
	private void buildBalancedTree(BankAccountsBinarySearchTree tree, List<BankAccount> list, int low, int high){
		/*if((high+low)/2 > 0){//checking the left side of the list
		tree.insert(list.get((high+low)/2));//adding the data from the place
		int middle = (high+low)/2;//changing the place
		buildBalancedTree(tree,list,0,middle);
		}
		tree.insert(list.get(low));//adding the data in the root
		if((high-low)/2 > 0){//checking the right side of the list
			tree.insert(list.get((high+low)/2));//adding the data from the place
			low = ((high+low)/2);//changing the place
			buildBalancedTree(tree,list,low,high);
		}
		tree.insert(list.get(high));*/
		if(low<=high){
			int middle = (high + low)/2;
			tree.insert(list.get(middle));
			buildBalancedTree(tree,list,middle+1,high);
			buildBalancedTree(tree,list,low,middle-1);
		}
	}

	public Iterator<BankAccount> iterator(){
		return new FilteredBankAccountsIterator(this);
	}
}
