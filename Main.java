import java.util.Arrays;
import java.util.Stack;

import static jdk.vm.ci.code.Location.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Füge 5 Elemente in den Stack ein
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Gibt die Anzahl der Elemente im Stack aus
        System.out.println("Anzahl der Elemente: " + stack.size());

        // Gibt das letzte Element des Stacks zurück und entferne es
        int lastElement = stack.pop();
        System.out.println("Letztes Element: " + lastElement);
        System.out.println("Anzahl der Elemente nach pop: " + stack.size());

        // Gibt das letzte Element des Stacks zurück, ohne den Stack zu modifizieren
        int peekElement = stack.peek();
        System.out.println("Peek-Element: " + peekElement);
        System.out.println("Anzahl der Elemente nach peek: " + stack.size());

        // Gibt die letzten 3 Elemente des Stacks zurück und entferne sie
        int n = 3;
        int[] popped = new int[n];
        for (int i = 0; i < n; i++) {
            popped[i] = stack.pop();
        }
        System.out.println("Popped Elements: " + Arrays.toString(popped));
        System.out.println("Size of Stack after pop: " + stack.size());
       // geht nixi
       /* Integer[] poppedElements = stack.pop(3);
         System.out.println("Popped Elements: " + Arrays.toString(poppedElements));
         System.out.println("Anzahl der Elemente nach pop(3): " + stack.size());*/
    }

}
