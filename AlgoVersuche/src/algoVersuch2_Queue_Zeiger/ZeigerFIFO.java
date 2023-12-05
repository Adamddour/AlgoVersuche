package algoVersuch2_Queue_Zeiger;

import java.util.NoSuchElementException;

public class ZeigerFIFO implements FIFOQueue {

	private KnotenNonGeneric node;

    @Override
    public FIFOQueue enqueue(char zeichen) {
        if (node == null) {
            node = new KnotenNonGeneric(zeichen, null);
        } else {
            KnotenNonGeneric aktuell = node;
            while (aktuell.getNext() != null) {
                aktuell = aktuell.getNext();
            }
            aktuell.setNext(new KnotenNonGeneric(zeichen, null));
        }
        return this;
    }

    @Override
    public FIFOQueue dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Stqack ist leer!");
        }
        node = node.getNext();
        return this;
    }

    @Override
    public char front() {
        // falls die Liste leer ist
        if (isEmpty()){
            throw new NoSuchElementException("Stack ist leer!!");
        }
        return node.getElement();
    }

    @Override
    public boolean isEmpty() {
        return node == null;
    }


    public static void main(String[] args){

        // objekt vom Typ LIFO
        ZeigerFIFO l1 = new ZeigerFIFO(); // länge ist bekannt aber werte sind nicht bekannt
        // Array ist leer
        // l1 -> ['\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0']

        // Schreiben wir ein Array (Werte sind bekannt)
        char[] zeichen = {'1', '2', '3', '4', '5', '6', '7', '8'};
        int index = 0;
        // i < 4 (da von 0 bis 3  --> 4 durchläufe werden durchgeführt)
        char element;
        for(int i = 0; i < 4;i++){
            element = zeichen[index]; // element = zeichen[index] = zeichen[0] = '1'
            index++; // index = 1;
            System.out.println("Hinzufügtes Element = " + element);
            l1.enqueue(element);
            element = zeichen[index]; // element = zeichen[index] = zeichen[1] = '2'
            index++; // index = 2;
            System.out.println("Hinzufügtes Element = " + element);
            l1.enqueue(element);
            // l1 -> ['1', '2', , , , , , ]
            System.out.println("Entferntes Element1 = " + l1.front()); // gibt '2' zurück
            l1.dequeue();
            // l1 --> ['1', , , , , , , ]
        }

  

        // Lösung - Variante 1  -->
        while(!l1.isEmpty()){
            System.out.println(l1.front()); // Ausgabe letzte eingefügte Element
            l1.dequeue(); // Entfernen letzte eingefügte Element
        }

    }

}

class KnotenNonGeneric {
    private char wert; // Das zu verwaltende Datenelement
    private KnotenNonGeneric next; // Referenz auf den nächsten Knoten
    public KnotenNonGeneric(char wert, KnotenNonGeneric next) {
        this.wert = wert;
        this.next = next;
    }

    /** Setzt die Referenz auf den Nachfolger-Knoten */
    public void setNext(KnotenNonGeneric next){
        this.next=next;
    }
    /** Gibt das Datenelement des Knotens zurück */
    public char getElement() { // Gibt das gespeicherte Objekt aus
        return wert;
    }
    /** Gibt den Nachfolge-Knoten zurück */
    public KnotenNonGeneric getNext() {
        return next;
    }
}
