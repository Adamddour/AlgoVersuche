package algoVersuch2_Queue_Array;

public interface FIFOQueue {

	
	FIFOQueue enqueue(char zeichen);

	FIFOQueue dequeue();
	 
	
	char front();

	boolean isEmpty();

}
