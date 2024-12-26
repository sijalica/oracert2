package part7streams; // BuilderExtrasOOO

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  Stream.Builder
*/

import java.util.stream.Stream;

public class BuilderExtrasOOO {
    public static void main(String[] args) {

        // Builder is mutable object, so like a StringBuilder,
        // you do not need to self reference, but you can...
        Stream.Builder<String> builder = Stream.builder();
        builder = builder.add("a");  // ok but not necessary
        builder.add("b");  // this works
        builder.add("c");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);

        // Using a raw Builder..
        Stream.Builder builder2 = Stream.builder();
        builder2.add(new Object());
//        builder2.add("a");
        Stream<String> s2 = builder2.build();
        s2.forEach(System.out::println);

        // Create a Stream of Integer
        Stream<Integer> integerStream = Stream.of(10, 20, 30);
        integerStream = integerStream.limit(2);
        integerStream.forEach(System.out::println);
    }
}