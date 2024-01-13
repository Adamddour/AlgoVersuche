package vorbereiten;

import javax.swing.*;
public class HashApp {
	
 public static void main (String args []) {
	 
	 TreeNode root = new TreeNode(5);
     int[] elements = {3, 7, 6, 10, 12, 9};

     for (int element : elements) {
         root.add(element);
     }

     System.out.print("In-Order Representation: ");
     root.printInOrder();
	 
 
 }
 
}

