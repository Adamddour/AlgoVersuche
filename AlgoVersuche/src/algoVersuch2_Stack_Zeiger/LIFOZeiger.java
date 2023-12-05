package algoVersuch2_Stack_Zeiger;

import algoVersuch2_Stack_Array.LIFOStack;

public class LIFOZeiger implements LIFOStack{

 private KnotenNonGeneric node;

 @Override
 public void push(char item) {
     KnotenNonGeneric neuerNode = new KnotenNonGeneric(item, null);
    
     if(node != null){
         neuerNode.setNext(node);
     }

     node = neuerNode;
 }

 @Override
 public char top() {
     if (isEmpty()){
         throw new IllegalArgumentException("Stack ist leer!!");
     }
     return node.getElement();
 }

 @Override
 public void pop() {
     if(isEmpty()){
         throw new IllegalArgumentException("Stqack ist leer!");
     }
     node = node.getNext();
 }
 @Override
 public boolean isFull() {
 	return false;
 }
 @Override
 public boolean isEmpty() {
     return node == null;
 }


 public static void main(String[] args){
     LIFOZeiger l1 = new LIFOZeiger();
     // Schreiben wir ein Array (Werte sind bekannt)
     char[] zeichen = {'1', '2', '3', '4', '5', '6', '7', '8'};
     int index = 0;
     char element;
     for(int i = 0; i < 4;i++){
         element = zeichen[index]; 
         index++; // index = 1;
         System.out.println("Hinzufügtes Element = " + element);
         l1.push(element);
         element = zeichen[index]; 
         index++; // index = 2;
         System.out.println("Hinzufügtes Element = " + element);
         l1.push(element);
         System.out.println("Entferntes Element222 = " + l1.top()); 
         l1.pop();
     }

     // Lösung - Variante 1  -->
     while(!l1.isEmpty()){
         System.out.println(l1.top()); 
         l1.pop(); // Entfernen letzte eingefügte Element
     }

 }

}

class KnotenNonGeneric {
 private char wert; 
 private KnotenNonGeneric next; 
 public KnotenNonGeneric(char wert, KnotenNonGeneric next) {
     this.wert = wert;
     this.next = next;
 }

 public void setNext(KnotenNonGeneric next){
     this.next=next;
 }
 public char getElement() { 
     return wert;
 }

 public KnotenNonGeneric getNext() {
     return next;
 }
 
}
