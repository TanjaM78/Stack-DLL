import java.util.NoSuchElementException;

public class StackDLL<E> {

    private DoubleLinkedList<E> list;

    public StackDLL() {
        this.list = new DoubleLinkedList<>();
    }
    /*push fügt ein neues Element am Anfang (also an der "obersten" Stelle) des Stacks ein.
     es wird die addFirst-Methode der zugrundeliegenden doppelt-verketteten Liste (DoubleLinkedList) aufgerufen. Diese Methode fügt ein neues Element am Anfang der Liste ein,
     indem es zuvor das erste Element der Liste auf das neue Element
     verweist und das neue Element auf das bisherige erste Element der Liste verweist. Dadurch wird die Reihenfolge der Elemente in der Liste umgedreht,
     so dass das neue Element an erster Stelle steht.*/

    public void push(E newElement) {
        list.addFirst(newElement);
    }
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    /*size() gibt die Anzahl der Elemente in der Liste zurück. Sie greift auf die Größe des unterliegenden DoubleLinkedList-Objekts list zu und gibt den Wert der getSize()-Methode dieser Liste zurück.*/
    public int size() {
        return list.getSize();
    }
    /* pop() entfernt und gibt das oberste Element des Stacks zurück.
       Zunächst wird geprüft, ob der Stack leer ist, d.h. ob die Größe des list-Objekts gleich 0 ist. Falls ja, wird eine NoSuchElementException geworfen, um anzuzeigen, dass kein Element im Stack vorhanden ist.
       Ansonsten wird das oberste Element des Stacks mit list.getHead().getData() abgerufen und in der Variablen data gespeichert.
       Das oberste Element wird dann durch Aufruf von list.removeFirst() aus der list-Datenstruktur entfernt.
       Schließlich wird das entfernte Element zurückgegeben.*/
    public E pop() {
        if (list.getSize() == 0) {
            throw new NoSuchElementException();
        }
        E data = list.getHead().getData();
        list.removeFirst();
        return data;
    }

    /* entfernt die obersten n Elemente vom Stack und gibt sie als Array von Ganzzahlen zurück.
    Wenn der übergebene Parameter negativ ist oder größer als die Anzahl der Elemente im Stack ist, wird eine IllegalArgumentException ausgelöst.
    In der Methode wird zuerst überprüft, ob der übergebene Parameter gültig ist. Wenn ja, wird ein neues Array mit der Größe n erstellt.
    In einer Schleife wird pop() aufgerufen, um das oberste Element vom Stack zu entfernen und in das Array zu legen. Am Ende wird das Array zurückgegeben.
    Beachten Sie, dass wir das pop()-Ergebnis in einen int umwandeln, da der Stack ein generischer Typ ist und das Rückgabewert ein Objekt vom Typ E ist, das in diesem Fall als int benötigt wird.
     */
    public int[] pop(int n) {
        if (n < 0 || n > list.getSize()) {
            throw new IllegalArgumentException();
        }
        int[] popped = new int[n];
        for (int i = 0; i < n; i++) {
            popped[i] = (int) pop();
        }
        return popped;
    }
    /* Gibt das oberste Element des Stacks zurück, ohne es aus dem Stack zu entfernen.
     * Wenn der Stack leer ist, wird eine NoSuchElementException geworfen.
     * @return das oberste Element des Stacks
     * @throws NoSuchElementException wenn der Stack leer ist*/
    public E peek() {
        if (list.getSize() == 0) {
            throw new NoSuchElementException();
        }
        return list.getHead().getData();
    }
    }



