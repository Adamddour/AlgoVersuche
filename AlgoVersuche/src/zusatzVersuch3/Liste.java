package zusatzVersuch3;



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
 int hashFunktion (String x,int b ) {
     return b-1;
 }

 

 /**
  * die Methode liefert den Hashwert für alle Eingabestrings
  * @param wert der Eingabestrings
  * @param hashtabelleLaenge die länge der Hashtabelle
  * @return den Index des Hash-Buckets, in den der String eingefügt werden soll.
  *
  */
 int neueHashFunktion (String wert, int hashtabelleLaenge){
     int index = wert.charAt(0) % hashtabelleLaenge;
     return index;
 }

 boolean istGueltigePosition (int p) {
     return (p >= 1) && (p <= laenge () );
 }

 void setzeCursor (int p){
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
     anfang = z;
 }


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


 void loescheElem (String e) {

     for (int i = 1; i <= laenge(); i++) {

         if(inhalt(i).equals(e))
             loesche(i);
     }

     //Loesche(Suche (e));
 }

 String inhalt (int p){
     setzeCursor (p);
     return cursor.inhalt;
 }


 int suche(String element) {
     for (int i = 0; i < laenge(); i++) {
         if (inhalt(i).equals(element)) {
             return i;
         }
     }
     return -1; // gibt -1 zurück, wenn das Element nicht gefunden wird
 }
}



