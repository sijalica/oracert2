package part7streams;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Sorting Streams
*/

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class Guest implements Comparable<Guest> {
    protected String first;
    protected String last;

    // Constructor
    Guest(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String toString() {
        return this.last + ", " + this.first;
    }

    public int compareTo(Guest o) {
        return last.compareToIgnoreCase(o.last);
    }

    public static int sortByFirst(Guest g1, Guest g2) {
        return g1.first.compareToIgnoreCase(g2.first);
    }
}

public class StreamsSorted {

    public static void main(String[] args) {

        // Test data
        List<String> initialData = List.<String>of("One", "Two", "Three",
                "Four", "Five", "Six", "Abc");

        // HashSet is unordered
        Set<String> unOrderedSet = new HashSet<String>(initialData);

        System.out.println("---- UnOrdered Stream ");
        // Stream<Stream> created, Print each element
        initialData.stream()
                // print each element
                .forEach((s) -> System.out.print(s + " "));

        System.out.println("\n---- Using sorted operation on Stream");
        initialData.stream()
                // Uses Natural Order, alphabetical
                .sorted()
                // print each element
                .forEach((s) -> System.out.print(s + " "));

        System.out.println("\n---- Using sorted with Stream of Guest");

        Stream.of(new Guest("Ann", "Jones"),
                        new Guest("Bob", "Smith"),
                        new Guest("Carol", "Green"))
                .sorted()
                .forEach(System.out::println);

//        Stream.of(new Guest("Ann", "Jones"),
//                        new Guest("Bob", "Smith"),
//                        new Guest("Carol", "Green"))
//                .sorted(Comparator.naturalOrder())
//                .forEach(System.out::println);

        Stream.of(new Guest("Ann", "Jones"),
                        new Guest("Bob", "Smith"),
                        new Guest("Carol", "Green"))
                .sorted((s, t) -> s.last.compareToIgnoreCase(t.last))
                .forEach(System.out::println);

        Stream.of(new Guest("Ann", "Jones"),
                        new Guest("Bob", "Smith"),
                        new Guest("Carol", "Green"))
                .sorted()
                .forEach(System.out::println);

        Stream.of(new Guest("Ann", "Jones"),
                        new Guest("Bob", "Smith"),
                        new Guest("Carol", "Green"))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        Stream.of(new Guest("Ann", "Jones"),
                        new Guest("Bob", "Smith"),
                        new Guest("Carol", "Green"))
                .sorted(Guest::sortByFirst)
                .forEach(System.out::println);
    }
}