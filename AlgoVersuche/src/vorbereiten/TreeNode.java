package vorbereiten;



public class TreeNode {
	
	//Aufgabe1
    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public boolean find(int k) {
        if (k == value) {
            return true;
        } else if (k < value && left != null) {
            return left.find(k);
        } else if (k > value && right != null) {
            return right.find(k);
        }
        return false;
    }

    public boolean add(int k) {
        if (k == value) {
            return false; // Element already exists
        } else if (k < value) {
            if (left == null) {
                left = new TreeNode(k);
                return true;
            } else {
                return left.add(k);
            }
        } else {
            if (right == null) {
                right = new TreeNode(k);
                return true;
            } else {
                return right.add(k);
            }
        }
    }
    
    //Aufgabe2
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(value + " ");
        if (right != null) {
            right.printInOrder();
        }
        
    }

}

