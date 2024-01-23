package vorbereiten;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {5,3,7,6,10,12,9};
		
		BinarySearchTree myTree = new BinarySearchTree(5);
		for (int i=1; i<arr.length; i++) {
			myTree.add(arr[i]);
		}
		
		System.out.println("Print: "+myTree.print());
		
		System.out.println("Suche nach 12,8: "  + myTree.find(12) + "," + myTree.find(8));
		//System.out.println("Lösche 12,8: " + myTree.delete(12) + "," + myTree.delete(8));
		System.out.println("Height: " + myTree.height());
		System.out.println("Depth: " + myTree.depth());
		System.out.println("Suche Minimum: " + myTree.getMin());
		System.out.println("Suche Maximum: " + myTree.getMax());
		System.out.println("Suche Nachfolger von: 10 ist " + myTree.getSuccessor(10)+","+ myTree.getSuccessor(7) );
		System.out.println("Vorgaenge:"+myTree.getPredecessor(7)+","+myTree.getPredecessor(5));
		System.out.println("Print: "+myTree.print());
	}

}
