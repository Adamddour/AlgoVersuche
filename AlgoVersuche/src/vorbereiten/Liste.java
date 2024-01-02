package vorbereiten;

public class Liste {
	
	
	 Zelle anfang;
	 Zelle cursor;
	 
	//nix ändern
	 int laenge (){
		 
		Zelle cur = anfang;
		int l =0;
		while (cur != null) {
			l++;
			cur = cur.next;
		}
		return l;
	}
	 
	 /**
	  * 
	  die Methode liefert den selben Hashwert für alle Eingabestrings
     * @param x der Eingabestrings
     * @param b die länge der Hashtabelle
     * @return den Index des Hash-Buckets, in den der String eingefügt werden soll.
     *         In dieser Methode wird immer der letzte Bucket der Hashtabelle zurückgegeben
	  */
	 /*int hashFunktion (String x,int b) {
		 	return b-1;
	 
	 }
	 */
	 
	 //Aufgabe 3:
	 
	 /**
	  * 
	  * @param wert Eingabestring
	  * @param laenge die länge der Hashtabelle
	  * @return der Index des Hash-Buckets, in den der String eingefügt werden soll
	  * ersteBuchstabe=(char)(ersteBuchstabe-32); konvertierung von klein zu großen Buchstaben
	  */
	 
	 int hashFunktion (String wert,int laenge) {
		 
		 int index=0;
		 char ersteBuchstabe=wert.charAt(0);
		 
		 if(ersteBuchstabe>='a'&&ersteBuchstabe<='z') {
			 ersteBuchstabe=(char)(ersteBuchstabe-32);
		 }
		
		 index=ersteBuchstabe%laenge;
		 return index;
		
	 
	 }
	 
	//nix ändern
	 boolean istGueltigePosition(int p) {
		 	return (p >= 1) && (p <= laenge () );
	 
	 }
	 
	 
	 //nix ändern
	 void setzeCursor (int p){
	 cursor = null;
	 if (istGueltigePosition (p) ) {
		 
		 Zelle cur = anfang;
		 for(int i = 1; i < p;i++)
			 cur = cur.next;
		 
		 cursor = cur;
	 	}
	}
	 
	//nix ändern
	 void einsetzenAnfang (String e){
		 
	 Zelle z = new Zelle (e,anfang);
	 anfang = z;
	 
	}
	 
	//nix ändern
	 void loesche (int p) {
		 if (istGueltigePosition(p)){
			 
			 if (p == 1) // Loesche 1. Zelle
				 anfang = anfang.next;
			 else {
			 setzeCursor(p-1);
			 cursor.next = cursor.next.next;
		 
			 }
		}
	 
	}
	 
	//nix ändern
	 void loescheElem (String e) {
			 for(int i = 1; i <= laenge(); i++) {
				 if(inhalt(i).equals(e))
				 loesche(i);
			}
	 //Loesche(Suche (e));
	}
	 
	//nix ändern
	 String inhalt (int p){
		 setzeCursor (p);
		 return cursor.inhalt;
	 
	 }
	 
	 //todo Aufgabe 2 a
	 int suche(String element) {
		 
		 for(int i=1;i<=laenge();i++) {
			 if(inhalt(i).endsWith(element)) {
				 
				 return i;
			 }
		 }
		 
		 return -1;
		 
	 }
	 
	//todo Aufageb 2 c
	 String zeigeAlleElement(int bucket) {
		 
		 String ausgabe="Elemente in Bucket "+bucket+" /n";
		 ausgabe+="------------------ /n";
		 for(int i=laenge();i>=1;i--) {
			 
			 ausgabe+=inhalt(i)+"/n";
		 }
		 ausgabe+="------------------ /n";
		 return ausgabe;
	 }
	 
	//todo Aufgabe 2 d
	String listenLaenge(int bucket) {
		String ausgabe="";
		
		ausgabe+="Bucket "+bucket+" hat "+laenge()+" Elemente/n";
		return ausgabe;
	}
	
	 
	 
	 
	 
	 
	//todo Aufgabe 4
	// (int)(Math.random() * range) + min;
     // Rückgabe liegt zwischen von min bis (min+range-1)
     // Länge von jeder String zwischen 3 und (3+8-1)
     // Länge von jeder String zwischen 3 und 10
     

     // große Buchstaben
	 
	 //innerhal der For-Schleife 
	// ((Math.random() * 26) + 65) --> zufäliger wert zwischen 65 und 90
     // dann zu char umwandeln
	 
	//Welcher Korb?
}
