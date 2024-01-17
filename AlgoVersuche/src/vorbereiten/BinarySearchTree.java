package vorbereiten;

public class BinarySearchTree {
	
	private Treenode root;
	
	public BinarySearchTree(int value) {
		root=new Treenode(value);
	}
	
	public boolean find(int value) {
		Treenode node=root;
		while(node!=null) {
			
			if(value<node.wert) {
				
				node=node.firstChild;
			}
			else if(value>node.wert) {
				node=node.secondChild;
			}
			else {
				return true;
			}

		}
		return false;
	}
	
	public boolean addNode(Treenode node,int value) {
		
		if(value<node.wert) {
			
			if(node.firstChild==null) {
				
				node.firstChild=new Treenode(value);
				return true;
			}
			else {
				return addNode(node.firstChild, value);
			}
			
		}
		else if(value>node.wert) {
			if(node.secondChild==null) {
				
				node.secondChild=new Treenode(value);
				return true;
			}
			else {
				return addNode(node.secondChild, value);
			}
		}
		else {
			return false;
		}

	}
	
	public boolean add(int value) {
		
		if(root==null) {
			root=new Treenode(value);
			return true;
		}
		return addNode(root, value);
	}
	
	private String print_st(Treenode node) {
		
		return (node!=null) ? node.wert +"{"
				+print_st(node.firstChild)
				+print_st(node.secondChild)
				+"}" : " null ";
	}
	
	public String print() {
		
		return print_st(root);
	}
	
	
	
	
	
	
	
}
