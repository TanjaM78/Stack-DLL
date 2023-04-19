import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StackDLLTest {

    private StackDLL<Integer> stack;
    /* neues Objekt des StackDLL-Typs initialisiert und der Variablen "stack" zugewiesen.
     Diese Initialisierung muss vor jedem Test durchgeführt werden, um sicherzustellen,
     dass jeder Testfall auf einem leeren Stack ausgeführt wird und nicht auf dem möglicherweise durch einen anderen Testfall beeinflussten Stack.*/
    @Before
    public void setUp() {
        stack = new StackDLL<>();
    }
    /*ein Element mit dem Wert 1 mittels push hinzugefügt. Anschließend wird überprüft, ob die Größe des Stacks korrekt aktualisiert wurde und ob sie 1 ist.
      Dann wird ein weiteres Element mit dem Wert 2 hinzugefügt und erneut überprüft, ob die Größe des Stacks korrekt aktualisiert wurde und ob sie nun 2 ist.
      Schließlich wird ein weiteres Element mit dem Wert 3 hinzugefügt und es wird noch einmal überprüft, ob die Größe des Stacks korrekt aktualisiert wurde und ob sie nun 3 ist.*/
    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.push(3);
        assertEquals(3, stack.size());
    }
    /*drei Elemente auf den Stack gelegt, dann werden diese mit der pop()-Methode wieder entfernt und überprüft, ob sie in der erwarteten Reihenfolge zurückgegeben werden.
      Anschließend wird überprüft, ob die Größe des Stacks 0 ist, nachdem alle Elemente entfernt wurden.
      Dieser Test stellt sicher, dass die pop()-Methode korrekt funktioniert, indem sie das oberste Element des Stacks entfernt und zurückgibt.*/
    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(0, stack.size());
    }
    /*ob eine NoSuchElementException ausgelöst wird, wenn pop() auf einem leeren Stack aufgerufen wird.
    Mit der Annotation @Test(expected = NoSuchElementException.class) wird erwartet, dass eine NoSuchElementException ausgelöst wird.
    Der Test wird bestanden, wenn tatsächlich eine NoSuchElementException ausgelöst wird.*/
    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }
    /*drei Elemente (1, 2 und 3) in den Stack eingefügt. Dann wird die Methode pop(2) aufgerufen, um die obersten 2 Elemente (3 und 2) aus dem Stack zu entfernen und in einem Array zu speichern.
     Das erhaltene Array wird mit dem erwarteten Array {3, 2} verglichen.
     Als nächstes wird pop(1) aufgerufen, um das letzte Element (1) aus dem Stack zu entfernen und in einem Array zu speichern. Das erhaltene Array wird mit dem erwarteten Array {1} verglichen.
     Schließlich wird überprüft, ob die Größe des Stacks nach dem Entfernen aller Elemente gleich 0 ist.*/
    @Test
    public void testPopN() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertArrayEquals(new int[]{3, 2}, stack.pop(2));
        assertArrayEquals(new int[]{1}, stack.pop(1));
        assertEquals(0, stack.size());
    }
    /*in negativer Wert ist für die pop Methode ungültig, da es nicht möglich ist, eine negative Anzahl von Elementen aus dem Stapel zu entfernen.
    Durch das Hinzufügen der @Test(expected = IllegalArgumentException.class) Annotation wird sichergestellt, dass der Test erfolgreich ist, wenn die erwartete IllegalArgumentException ausgelöst wird.*/
    @Test(expected = IllegalArgumentException.class)
    public void testPopNInvalidArgument() {
        stack.pop(-1);
    }
    /*Es werden drei Elemente in den Stack eingefügt und jeweils der aktuelle oberste Wert mit assertEquals() überprüft. Zunächst wird 1 in den Stack eingefügt und dann überprüft, ob peek() den Wert 1 zurückgibt.
     Anschließend wird 2 in den Stack eingefügt und erneut geprüft, ob peek() nun den Wert 2 zurückgibt. Zuletzt wird das oberste Element mit pop() entfernt und geprüft, ob peek() nun wieder den Wert 1 zurückgibt.*/
    @Test
    public void testPeek() {
        stack.push(1);
        assertEquals(Integer.valueOf(1), stack.peek());
        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.peek());
        stack.pop();
        assertEquals(Integer.valueOf(1), stack.peek());
    }
    /* wenn man peek() auf einem leeren Stack aufruft, also wenn es kein oberstes Element gibt, auf das man zugreifen kann.*/
    @Test(expected = NoSuchElementException.class)
    public void testPeekEmptyStack() {
        stack.peek();
    }

    /*Zuerst wird die Größe des Stacks getestet, wenn dieser leer ist (0 erwartet).
     Dann wird ein Element zum Stack hinzugefügt und die Größe wird überprüft (1 erwartet).
     Ein weiteres Element wird hinzugefügt und die Größe wird erneut getestet (2 erwartet). Schließlich wird ein Element aus dem Stack entfernt und die Größe wird erneut getestet (1 erwartet).*/
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }
    /*Der Test erstellt zuerst einen leeren Stack und prüft, ob dieser mit der Methode isEmpty() als leer erkannt wird.
     Dann wird ein Element hinzugefügt und geprüft, ob der Stack jetzt nicht mehr leer ist. Anschließend wird das Element wieder entfernt und überprüft, ob der Stack erneut als leer erkannt wird.*/
    @Test
    public void testIsEmpty() {
        StackDLL<Integer> stack = new StackDLL<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }


}

