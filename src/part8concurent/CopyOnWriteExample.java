package part8concurent;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  CopyOnWriteArrayList
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
    public static void testList(List<String> currentList) {
        System.out.println("----------- Testing " +
                currentList.getClass().toGenericString());
        System.out.println("Original State: " + currentList);
        // Get Iterator
        Iterator<String> it = currentList.iterator();

        int i = 0;

        // Use iterator
        System.out.println("Print first three elements: ");
        while (it.hasNext()) {
            System.out.println(it.next());
            // Add some elements while iterating over elements
            if (i++ == 0) {
                // currentList.addAll(List.of("James", "Jim", "Joe"));
                it.remove();
            }
            // break after third element
            else if (i == 3) break;
        }

        // Print remaining elements on iterator
        System.out.println("Printing remaining elements");
        it.forEachRemaining(System.out::println);

        System.out.println("Values = " + currentList + "\n");
    }

    public static void main(String[] args) {

        // Create an ArrayList and initialize with 5 values
        List<String> alist = new ArrayList<>(List.of("" +
                "David", "Evan", "Anne", "Bob", "Carol"));

        // Create a CopyOnWriteArrayList using previous list
        List<String> concurrentList = new CopyOnWriteArrayList<>(alist);

        testList(alist);

        System.out.println(concurrentList);
        System.out.println(alist);

    }
}