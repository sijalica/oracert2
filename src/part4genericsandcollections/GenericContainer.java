package part4genericsandcollections;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics & Wildcards
*/

import java.util.ArrayList;
import java.util.List;

public class GenericContainer {

    // Container wraps an ArrayList
    List wrappedList;

    // Constructor
    GenericContainer(List wrappedList) {
        this.wrappedList = wrappedList;
    }

    // Wrap get method with custom one
    public Object myGet(int index) {
        return wrappedList.get(index);
    }

    // Wrap add method with custom one
    public void myAdd(Object o) {
        wrappedList.add(o);
    }

    // Wrap ArrayList.toString()
    public String toString() {
        return wrappedList.toString();
    }

    // Main method declares and constructs an instance
    public static void main(String[] args) {
        List l = new ArrayList();
        GenericContainer g = new GenericContainer(l);

        // Add elements to wrapped List
        g.myAdd("hi");
        g.myAdd(10);

        // Get first element from wrapped List
        Object o = g.myGet(0);
        System.out.println("Element 0 = " + o);

        // Print List
        System.out.println("Wrapped List = " + g);
    }

}