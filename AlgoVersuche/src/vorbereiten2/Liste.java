package vorbereiten2;

public class Liste {
 Zelle anfang;
 Zelle cursor;


 // [1,2,3,4,6,...]
 int laenge () {
     Zelle cur = anfang;
     int l = 0;
     while (cur != null) {
         l++;
         cur = cur.next;
     }

     return l;
 }

 /**
  * die Methode liefert den selben Hashwert für alle Eingabestrings
  * @param x der Eingabestrings
  * @param b die länge der Hashtabelle
  * @return den Index des Hash-Buckets, in den der String eingefügt werden soll.
  *         In dieser Methode wird immer der letzte Bucket der Hashtabelle zurückgegeben
  */
 /*
 int hashFunktion (String x,int b ) {
     return b-1;
 }
  */


 /**
  * die Methode liefert den Hashwert für alle Eingabestrings
  * @param wert der Eingabestrings
  * @param hashtabelleLaenge die länge der Hashtabelle
  * @return den Index des Hash-Buckets, in den der String eingefügt werden soll.
  *
  */
 
 int hashFunktion(String wert, int hashtabelleLaenge){
     int index = 0;
     char ersteBuchstabe = wert.charAt(0);
     
     if(ersteBuchstabe >= 'a' && ersteBuchstabe <= 'z')
         ersteBuchstabe = (char) (ersteBuchstabe - 32);

     index = ersteBuchstabe % hashtabelleLaenge;
     return index;
 }

 boolean istGueltigePosition (int p) {
     return (p >= 1) && (p <= laenge () );
 }



   

 void setzeCursor (int p){
     // crusor zeigt auf null, wenn die Position ungültig ist ( <1 odwer >länge)
     cursor = null;
     if (istGueltigePosition(p) ) {
         Zelle cur = anfang;
         for (int i = 1; i < p;i++)
             cur = cur.next;
         cursor = cur;
     }
 }

 void einsetzenAnfang (String e){
     Zelle z = new Zelle (e,anfang);
     // anfang aktualisiseren
     anfang = z;
 }


 
 void loesche (int p) {
     if (istGueltigePosition(p)){ // true
       
         if (p == 1) // Loesche 1. Zelle
             anfang = anfang.next;
         else {
             // Aufruf von setzeCursor
             setzeCursor(p-1);
             
             cursor.next = cursor.next.next;
            
         }
     }
 }

 
 void loescheElem (String e) {
     for (int i = 1; i <= laenge(); i++) {
         if(inhalt(i).equals(e))
             loesche(i);
     }
     
 }
 

 String inhalt (int p){
     setzeCursor (p);
     return cursor.inhalt;
 }

 
 int suche(String element) {
     
     for (int i = 1; i <= laenge(); i++) {
         if (inhalt(i).equals(element)) {
             return i;
         }
     }
     return -1; // gibt -1 zurück, wenn das Element nicht gefunden wird
 }

 
 String zeigeAlleElementeInBucket(int bucket){
     String ausgabe = "Elemente in Bucket " + bucket +" :\n";
     ausgabe += "--------------------------------------\n";
     for (int i = laenge(); i >= 1; i--) {
         ausgabe += inhalt(i) + "\n";
     }
     
     ausgabe += "--------------------------------------\n";
     return ausgabe;
 }

 String listenLaengen(int bucket){
     String ausgabe = "";
     ausgabe += "Bucket " + bucket + " hat " + laenge() + " Elemente\n";
     return ausgabe;
 }
}



