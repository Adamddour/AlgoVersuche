package vorbereiten;

import javax.swing.*;
public class HashApp {
 public static void main (String args []) {
	 
	 
	 final int B = 5;
	 String menue = "Eingabe\n" ;
	 menue += " 1) Element einfuegen\n";
	 menue += " 2) Element suchen\n";
	 menue += " 3) Zelle loeschen\n";
	 menue += " 4) Laenge der Liste von Korb k\n";
	 menue += " 5) Liste von Korb k ansehen\n";
	 menue += " 6) Laenge der Listen von allen Koerben\n";
	 menue += " 7) Liste zufaellig fuellen\n";
	 
	 
	 String ausgabe="";
	 Liste hashTabelle[];
	 hashTabelle = new Liste [B];
	 for (int i = 0; i < B;i++)
	 hashTabelle[i] = new Liste();
	 while (true) {
		 String menueeingabe = JOptionPane.showInputDialog(menue);
		 if (menueeingabe == null)
			 break;
		 	String dialogEingabe;
		 	if (menueeingabe.equals("1")) {
		 		
				 dialogEingabe = JOptionPane.showInputDialog("Datenstring?");
				 
				 //int zahl = Integer.parseInt (eingabe);
				 
				 int h = hashTabelle[0].hashFunktion(dialogEingabe, B); //Welcher Korb?
				 boolean existsInHashtable = false;
				 for (int j = 1; j <= hashTabelle[h].laenge(); j++) {
				 if (hashTabelle[h].inhalt(j).equals(dialogEingabe))
					 ausgabe = "Element in Korb " + h + " gefunden, daher nicht eingefuegt";
					 existsInHashtable = true;
					 break;
				 }
				 if (!existsInHashtable) {
					 hashTabelle[h].einsetzenAnfang(dialogEingabe);
					 ausgabe = "Eingabe eingefuegt in bucket " + h;
				 }
				 JOptionPane.showMessageDialog(null, ausgabe);
		 	}
		 	
		 	if (menueeingabe.equals("2")) {
		 			dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gesucht werden?");
		 			ausgabe = "";
		 			
		 			int h=hashTabelle[0].hashFunktion(dialogEingabe, B);
		 			int position=hashTabelle[h].suche(dialogEingabe);
		 			
		 			if(position!=-1) {
		 				
		 				ausgabe="Element in Bucket "+h+" in Korb "+position;
		 			}
		 			else {
		 				ausgabe="Nicht gefunden";
		 			}
		 			JOptionPane.showInputDialog(null,ausgabe);
		 	}
		 	
		 	if (menueeingabe.equals("3")) {
		 		dialogEingabe = JOptionPane.showInputDialog("Welches Element soll geloescht werden?");
		 		ausgabe = "";
		 		
		 		
		 	}
		 	if (menueeingabe.equals("4")) {
		 		dialogEingabe = JOptionPane.showInputDialog("Von welchem Korb soll die Laenge angezeigt werden?");
		 		ausgabe = "";
		 		int k = Integer.parseInt(dialogEingabe);
		 		int l = hashTabelle[k].laenge();
		 		ausgabe = "Liste hat L�nge " + l;
		 		JOptionPane.showMessageDialog(null, ausgabe);
		 	}
		 	
		 	if (menueeingabe.equals("5")) {
		 		//...
		 	}
		 	
		 	
		 	if (menueeingabe.equals("6")) {
		 		//...
		 	}
		 	
		 	if (menueeingabe.equals("7")) {
		 		
		 		dialogEingabe = JOptionPane.showInputDialog("Anzahl?");
		 		ausgabe = "";
				 int zahl = Integer.parseInt(dialogEingabe);
				 for (int j = 1; j <= zahl; j++) {
				 String s = "";
				 int laenge = (int) ((Math.random() * 8) + 3);
				 for (int k = 1; k <= laenge; k++) {
				 char zufall = (char) ((Math.random() * 26) + 65);
				 s += zufall;
			}
				 int h = hashTabelle[0].hashFunktion(s, B); //Welcher Korb?
				 hashTabelle[h].einsetzenAnfang(s);
				 }
		 	}
	 	}
 	}
}

