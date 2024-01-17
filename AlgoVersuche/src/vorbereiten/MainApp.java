package vorbereiten;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree bst=new BinarySearchTree(5);
		int[] elemente= {3,7,6,10,12,9};
		
		for(int ele : elemente) {
			bst.add(ele);
		}
		System.out.println("Baum::: "+bst.print());
		

	}

}
