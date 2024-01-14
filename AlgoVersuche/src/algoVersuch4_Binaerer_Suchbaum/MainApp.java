package algoVersuch4_Binaerer_Suchbaum;

public class MainApp {
	
	
	public static void main(String[] args) {
		
		//1.3 
			BinarySearchTree bst = new BinarySearchTree(5);
		    int[] elements = {3, 7, 6, 10, 12, 9};
		    for (int element : elements) {
		        bst.add(element);
		    }
		    System.out.println("Baumstruktur: " + bst.print());
		    
		    int treeHeight = BinarySearchTree.height(bst.getRoot());
		    System.out.println("Höhe des Baumes: " + treeHeight);
		    
		    boolean deleted7 = bst.delete(10);
		    boolean deleted10 = bst.delete(7);
		
		    System.out.println("Baumstruktur nach Löschen von 7 und 10:    " + bst.print());
		    
		    
		    //Aufruf für depth()-Methode
		    /*int valueToFindDepth = 6;  // Beispielwert
		    int depth = BinarySearchTree.depth(bst.getRoot(), valueToFindDepth);

		    if (depth != -1) {
		        System.out.println("Die Tiefe von " + valueToFindDepth + " im Baum beträgt: " + depth);
		    } else {
		        System.out.println(valueToFindDepth + " wurde im Baum nicht gefunden.");
		    }*/
		    
		   
	}
}
