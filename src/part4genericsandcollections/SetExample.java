package part4genericsandcollections;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Sets TreeSet, HashSet, LinkedHashSet
*/

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        // Initialize some data
        List<Integer> initialData = List.of(10, 20, 50, 40, 30);

        // Create a set from this list, best practice to declare variables
        // to the interface type as shown here.
        Set<Integer> h = new HashSet<>(initialData);
        System.out.println("----------- HashSet -----------");
        System.out.println("Original values entered: " + initialData);

        // Call static method on CollectionTests to exercise the Collections methods
        CollectionTests.doStuffWithCollection(h, 60, 50, 10);

        Set<Integer> t = new TreeSet<>(initialData);
        System.out.println("\n----------- TreeSet -----------");
        System.out.println("Original values entered: " + initialData);
        CollectionTests.doStuffWithCollection(t, 60, 50, 10);

        Set<Integer> l = new LinkedHashSet<>(initialData);
        System.out.println("\n----------- LinkedHashSet -----------");
        System.out.println("Original values entered: " + initialData);
        CollectionTests.doStuffWithCollection(l, 60, 50, 10);

        if (h.equals(t)) {
            System.out.println("HashSet h is equal to TreeSet t"); // true
        } else {
            System.out.println("HashSet h is NOT equal to TreeSet t");
        }

        h.add(null);
        if (h.equals(l)) {
            System.out.println("HashSet h is equal to LinkedHashSet t");
        } else {
            System.out.println("HashSet h is NOT equal to LinkedHashSet t");
        }

        System.out.println("\n----- Additional TreeSet Methods -------");

// cast t to a TreeSet variable to invoke TreeSet methods
        TreeSet<Integer> treeSet = (TreeSet<Integer>) t;

// lower returns the greatest element < (less than) the parameter
// value or null if no smaller element exists
        System.out.println("Using lower with values (1, 10, 20, 50, 51): "
                + treeSet.lower(1) + " : "
                + treeSet.lower(10) + " : "
                + treeSet.lower(20) + " : "
                + treeSet.lower(50) + " : "
                + treeSet.lower(51));

// floor returns the greatest element <= (less than or equal to) the
// parameter value or null if no smaller element exists
        System.out.println("Using floor with values (1, 10, 20, 50, 51): "
                + treeSet.floor(1) + " : "
                + treeSet.floor(10) + " : "
                + treeSet.floor(20) + " : "
                + treeSet.floor(50) + " : "
                + treeSet.floor(51));

// ceiling returns the least element >= (greater than or equal to)
// the parameter value or null if no greater element exists
        System.out.println("Using ceiling with values (1, 10, 20, 50, 51) : "
                + treeSet.ceiling(1) + " : "
                + treeSet.ceiling(10) + " : "
                + treeSet.ceiling(20) + " : "
                + treeSet.ceiling(50) + ": "
                + treeSet.ceiling(51));

// higher returns the least element > (greater than) the parameter
// value or null if no greater element exists
        System.out.println("Using higher with values (1, 10, 20, 50, 51): "
                + treeSet.higher(1) + " : "
                + treeSet.higher(10) + " : "
                + treeSet.higher(20) + " : "
                + treeSet.higher(50) + " : "
                + treeSet.higher(51));
    }
}