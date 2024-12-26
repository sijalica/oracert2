package part4genericsandcollections;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Queue: ArrayDeque, LinkedList
*/

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        List<Integer> initialData = List.of(10, 20, 50, 40, 30);

        System.out.println("\n----------- ArrayDeque -----------");
        System.out.println("Original values entered: " + initialData);

        Queue<Integer> arrayQueue = new ArrayDeque<>(initialData);
        CollectionTests.doStuffWithCollection(arrayQueue, 60, 50, 10);

        System.out.println("\n----------- LinkedList -----------");
        System.out.println("Original values entered: " + initialData);

        Queue<Integer> linkedList = new LinkedList<>(initialData);
        CollectionTests.doStuffWithCollection(linkedList, 60, 50, 10);

    }
}