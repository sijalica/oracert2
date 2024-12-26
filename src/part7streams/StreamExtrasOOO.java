package part7streams; // StreamExtrasOOO

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  Stream pipelines & lambda expressions

*/

import java.util.stream.Stream;

public class StreamExtrasOOO {
    public static void main(String[] args) {

        // Create a Stream of Integer
        Stream<Integer> stream = Stream.of(10, 20, 30);
        stream = stream.limit(2);
        stream.forEach(System.out::println);
    }
}