package vorbereiten;

public class BinarySearchTree {
	
	private Treenode root;
	
	
	BinarySearchTree(int value){
		root=new Treenode(value);
	}
	
	//1.1.a
	public boolean find(int value) {
		Treenode node=root;
		
		while(node!=null) {
			
			if(value<node.wert) {
				node=node.firstChild;
			}
			else if(value>node.wert) {
			
				node=node.secondChild;
			}
			return true;
		}
		
		
		return false;
	}
	

	
	//1.1.b
	public boolean addNode(Treenode node,int value) {
		
		if(value<node.wert) {
			
			if(node.firstChild==null) {
				node.firstChild=new Treenode(value);
				return true;
			}
			else {
				return addNode(node.firstChild,value);
			}
			
		}
		else if(value>node.wert) {
			
			if(node.secondChild==null) {
				node.secondChild=new Treenode(value);
				return true;
			}
			else {
				return addNode(node.secondChild,value);
			}
		}
		else {
			return false;
		}
	}
	//1.1.b
	public boolean add(int value) {
		if(root==null) {
			root=new Treenode(value);
			return true;
		}
		
		return addNode(root,value);
		
	}
	
	
	
}
