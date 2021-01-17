/*---------------------------------------
 Genuine author: <barak rapke>, I.D.: <315309666>
 Date: 01-01-2019 
---------------------------------------*/
public class BinaryNode<T> {

    protected T data;
    protected BinaryNode<T> left;
    protected BinaryNode<T> right;

    public BinaryNode(T element) {
        if (element == null)
            throw new IllegalArgumentException();
        this.data = element;
        left = null;
        right = null;
    }

    public void insert(T element) {
        if (Math.random() < 0.5) {
            if (left == null) left = new BinaryNode<T>(element);
            else left.insert(element);
        } else {
            if (right == null) right = new BinaryNode<T>(element);
            else right.insert(element);
        }
    }

    public BinaryNode<T> remove(T toRemove) {
        BinaryNode<T> output = this;

        if (data.equals(toRemove)) {
            if (left != null) {
                data = left.data;
                left = left.remove(data);
            } else if (right != null) {
                data = right.data;
                right = right.remove(data);
            } else output = null;
        } else {
            if (left != null && left.contains(toRemove))
                left = left.remove(toRemove);
            else if (right != null)
                right = right.remove(toRemove);
        }
        return output;
    }

    public boolean contains(T element) {
        boolean found = false;
        if (data.equals(element))
            found = true;
        else if (left != null && left.contains(element))
            found = true;
        else if (right != null && right.contains(element))
            found = true;
        return found;
    }

    public int height() {
        int leftH = -1, rightH = -1;
        if (left != null)
            leftH = left.height();
        if (right != null)
            rightH = right.height();
        return Math.max(leftH, rightH) + 1;
    }

    public int size() {
        int leftS = 0, rightS = 0;
        if (left != null)
            leftS = left.size();
        if (right != null)
            rightS = right.size();
        return leftS + rightS + 1;
    }

    public boolean equals(Object other) {
        boolean isEqual = true;
        //Check type
        if (!(other instanceof BinaryNode<?>))
            isEqual = false;
        else {
            BinaryNode<?> otherNode = (BinaryNode<?>) other;
            //Check data
            if (!data.equals(otherNode.data))
                isEqual = false;
                //Check left
            else if (((left == null) | (otherNode.left == null)) & (left != otherNode.left))
                isEqual = false;
            else if ((left != null) && !left.equals(otherNode.left))
                isEqual = false;
                //Check right
            else if (((right == null) | (otherNode.right == null)) & (right != otherNode.right))
                isEqual = false;
            else if ((right != null) && !right.equals(otherNode.right))
                isEqual = false;
        }
        return isEqual;
    }
    
    private String eachSpace(String str1) {//the function getting string and put 2 spaces before every row
		String str ="";
		String[] strSplited = str1.split("\n");//I read about split function in the internet and she seperated among every string
		for (int i = 0; i < strSplited.length; i++) {
			str=str+("  ");//adding 2 spaces in line i
			str=str+(strSplited[i]);//adding the date from the string
			if (i != strSplited.length - 1) {//if it's not the last line,jump line
				str=str+("\n");
			}
		}
		return str.toString();
	}

    //Complete the following method
    public String toString() {
    	String str ="";
		if (left != null) {
			str=str+(eachSpace(left.toString()));//adding the left side of the tree to the string
			str=str+("\n");
		}
		str=str+(data.toString());//adding the root to the string
		if (right != null) {
			str=str+("\n");
			str=str+(eachSpace(right.toString()));//adding the right side of the tree to the string
		}
		return str.toString();
    }
    
 }