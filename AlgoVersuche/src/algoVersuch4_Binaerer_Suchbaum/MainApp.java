package algoVersuch4_Binaerer_Suchbaum;

public class MainApp {
	
	
	public static void main(String[] args) {
		
		//1.3 
			BinarySearchTree bst = new BinarySearchTree();
		    int[] elements = {5,3, 7, 6, 10, 12, 9};
		    for (int element : elements) {
		        bst.add(element);
		    }
		    System.out.println("Baumstruktur: " + bst.print());
		    
		    //System.out.println("Baumstruktur: " + bst.find(70));
		    
		    int treeHeight = BinarySearchTree.height(bst.getRoot());
		    
		    boolean deleted7 = bst.delete(10);
		    System.out.println("Baumstruktur: " + bst.print());
	
	}
}
