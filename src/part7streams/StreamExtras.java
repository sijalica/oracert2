package part7streams;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: additional Collectors.toMap and Collectors.groupingBy
*/

import part7streams.element.Pet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExtras {
    public static void main(String[] args) {
        List<Pet> petPopulation = Stream.generate(Pet::new)
                .limit(5)
                .collect(Collectors.toList());

        petPopulation.forEach(System.out::println);

    }
}