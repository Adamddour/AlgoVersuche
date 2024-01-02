package vorbereiten;
import java.math.*;
import java.util.*;

public class CountingSort {

	
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		int monat;
		System.out.println("Bitte Monat eingeben:");
		monat=sc.nextInt();
		
		switch(monat) {
		case 1:{
			System.out.println("Januar");
		}break;
		
		case 2:{
			System.out.println("F");
		}break;
		
		default :{
			System.out.println("Falsche Eingabe");
		}
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*double startK=1000;
		double zinsen=0.023;
		double zinsBetrag;
		
		int jahr=1;
		
		while(startK<=2000) {
			
			zinsBetrag=startK*zinsen;
			startK=startK+zinsBetrag;
			System.out.println("Jahr: "+jahr);
			jahr++;
		}
		*/
		
		
		/*double startK=1000;
		int jahr=10;
		double zinsen=0.034;
		double zinsBetrag=0;
		
		for(int i=1;i<=10;i++) {
			
			zinsBetrag=startK*zinsen;
			startK=startK+zinsBetrag;
			System.out.println("Zins Betrag= "+zinsBetrag+" Endsumme="+startK);
		}*/
	}
	
}
