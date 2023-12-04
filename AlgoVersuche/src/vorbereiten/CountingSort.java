package vorbereiten;

public class CountingSort {

	public static void countingSort(char[] a) {
		
		int max=a[0];
		int min=a[0];
		
		//rang berechnen
		for(int i=0;i<a.length;i++) {
			
			if(a[i]>max) {
				max=a[i];
			}
			if(a[i]<min) {
				min=a[i];
			}
			
		}
		int rang=max-min+1;
		int[] count=new int[rang];
		
		//Häufigkeit
		for(int i=0;i<a.length;i++) {
			count[a[i]-min]++;
		}
		
		//Sortieren
		
		int j=0;
		for(int i=rang-1;i>=0;i--) {
			
			while(count[i]>0) {
				a[j++]=(char)(i+min);
				count[i]--;
			}
			
		}
		
		//Ausgeben
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
			if(i!=a.length-1) {
				System.out.print(", ");
			}
		}
	}
	
	public static void main(String[] args) {
		char[] a= {'c','b','a','b','f','k','s'};
		countingSort(a);
	}
	
}
