package vorbereiten2;

import javax.swing.*;
import java.util.NoSuchElementException;

public class HashApp {
	
	/**
	 * 
	 * @param args
	 */
    public static void main (String args []) {

        final int B = 5;
        String  menue = "Eingabe\n" ;
        menue += " 1) Element einfuegen\n";
        menue += " 2) Element suchen\n"; //TODO
        menue += " 3) Zelle loeschen\n"; //TODO
        menue += " 4) Laenge der Liste von Korb k\n";
        menue += " 5) Liste von Korb k ansehen\n"; //TODO
        menue += " 6) Laenge der Listen von allen Koerben\n"; //TODO
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
                    if (hashTabelle[h].inhalt(j).equals(dialogEingabe)){
                        ausgabe = "Element in Korb " + h + " gefunden, daher nicht eingefuegt";
                        existsInHashtable = true;
                        break;
                    }

                }
                if (!existsInHashtable) {
                    hashTabelle[h].einsetzenAnfang(dialogEingabe);
                    ausgabe = "Eingabe eingefuegt in bucket " + h;
                }
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            if (menueeingabe.equals("2")) {
                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gesucht werden?");
               
                int h = hashTabelle[0].hashFunktion(dialogEingabe, B);
                
                int position = hashTabelle[h].suche(dialogEingabe);
              
                if(position != -1){
                   
                    ausgabe = "Element gefunden in Bucket " + h + ", die Nummer des Korbes : " + position;
                }else{
                    ausgabe = "Element nicht gefunden";
                }
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            if (menueeingabe.equals("3")) {

               
                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll geloescht werden?");

                int h = hashTabelle[0].hashFunktion(dialogEingabe, B);
               
                int position = hashTabelle[h].suche(dialogEingabe);
               
                if(hashTabelle[h].laenge() == 0){
                    throw new IllegalArgumentException("Bucket ist leer!!");
                }
                if(position == -1){
                    throw new NoSuchElementException("Element existiert nicht");
                }

                String loeschendeElement = hashTabelle[h].inhalt(position);
              
                hashTabelle[h].loescheElem(dialogEingabe);
                ausgabe = "Element in Bucket "+ h + " --> " + loeschendeElement + " gelöscht!";
                JOptionPane.showMessageDialog(null, ausgabe);
               
            }

            if (menueeingabe.equals("4")) {
                dialogEingabe = JOptionPane.showInputDialog("Von welchem Korb soll die Laenge angezeigt werden?");
                
                int k = Integer.parseInt(dialogEingabe);
                int l = hashTabelle[k].laenge();
                ausgabe = "Liste hat Laenge " + l;
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            if (menueeingabe.equals("5")) {
                
                dialogEingabe = JOptionPane.showInputDialog("Welcher Bucket soll gezeigt werden?");
                int bucket = Integer.parseInt(dialogEingabe);
                
                if(bucket < 0 || bucket > B){
                    throw new IllegalArgumentException("In der Hashtabelle stehen nur Buckets von 0 bis 4!!");
                }
                
                if(hashTabelle[bucket].laenge() == 0){
                    throw new IllegalArgumentException("Bucket ist leer!!");
                }
               
                ausgabe = hashTabelle[bucket].zeigeAlleElementeInBucket(bucket);
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            if (menueeingabe.equals("6")) {
               
                ausgabe = "Anzahl der Elemente in jedem Bucket in der Hashtabelle:\n";
                
                for(int i = 0; i < B; i++){
                    ausgabe += hashTabelle[i].listenLaengen(i);
                }

                JOptionPane.showMessageDialog(null, ausgabe);
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
                        // ((Math.random() * 26) + 65) --> zufäliger wert zwischen 65 und 90
                        // dann zu char umwandeln
                        s += zufall;
                    }
                    int h = hashTabelle[0].hashFunktion(s, B); //Welcher Korb?
                    hashTabelle[h].einsetzenAnfang(s);
                }
            }

        }
    }
}
