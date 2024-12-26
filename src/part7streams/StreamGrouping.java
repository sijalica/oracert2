package part7streams;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Stream Grouping
*/

import part7streams.element.Pet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGrouping {
    public static void main(String[] args) {

        // Print one Pet object
        System.out.println(new Pet());

        // Create a randomly generated list of 5000 pets.
        List<Pet> petPopulation = Stream.generate(Pet::new)
                .limit(5000)
                .collect(Collectors.toList());

        // Count the number of Dogs
        System.out.println("Number of Dogs = " +
                petPopulation.stream()
                        .filter((s) -> s.getType() == "Dog")
                        .count());

        // Count Pet Population by each Pet Type
        Map<String, Long> petTypeCounts = petPopulation.stream()
                // Collects to Map<String,Long> where key=pet type
                .collect(Collectors.groupingBy(Pet::getType,
                        Collectors.counting()));

        System.out.println("--- Counts by Pet Type: ---");
        // Create a stream from Map.entrySet()
        petTypeCounts.entrySet().stream()
                // Sort stream by pet type (key for Map)
                // .sorted((s, t) -> s.getKey().compareTo(t.getKey()))
                .sorted(Map.Entry.comparingByKey())
                // Print element: a key/value pair
                .forEach(System.out::println);

        System.out.println("--- Counts by Pet Type: ---");
        petPopulation.stream()
                // Collects to Map<String,Long> where key=pet type
                .collect(Collectors.groupingBy(Pet::getType,
                        Collectors.counting()))
                // Create a stream from Map.entrySet()
                .entrySet().stream()
                // Sort stream by pet type (key for Map)
                .sorted((s, t) -> s.getKey().compareTo(t.getKey()))
                // Print element: a key/value pair
                .forEach(System.out::println);

        System.out.println("--- Average Age by State, PetType: ---");
        Map<List, Double> petMaps = petPopulation.stream()
                // Collect data into a Map<List,Double>
                .collect(
                        Collectors.groupingBy(
                                // Grouping by list of attributes
                                p -> Arrays.asList(
                                        p.getState(), p.getType()),
                                // Get average age of pet
                                Collectors.averagingInt(Pet::getAge)));

        // Can get very specific about requesting information from Map
        System.out.printf(
                "Average age of a dog in CO = %.2f %n",
                petMaps.get(Arrays.asList("CO", "Dog")));

        System.out.println("--- Counts by State, PetType: ---");
        petPopulation.stream()
                // Collect data into a Map<List,Long>
                .collect(
                        Collectors.groupingBy(
                                // Grouping by list of attributes
                                p -> Arrays.asList(p.getState(), p.getType()),
                                // Count pets by state, type
                                Collectors.counting()))
                // Create a stream from Map.entrySet()
                .entrySet().stream()
                // Sort first by state, then type, each part of key which is List
                .sorted(Comparator.comparing(s -> (s.getKey().get(0) + s.getKey().get(1))))
                // Limit data to just Cat and Dog
                .filter((s) -> (s.getKey().get(1).equals("Cat") ||
                        s.getKey().get(1).equals("Dog")))
                // Print each mapped entry
                .forEach(System.out::println);

        //Creates bifurcated population
        Map<Boolean, List<Pet>> dogsAndNotDogs =
                petPopulation.stream().collect(
                        // Map<Boolean,List<Pet>
                        Collectors.partitioningBy(s -> s.getType().equals("Dog"))
                );

        System.out.println("Print first five dogs");
        dogsAndNotDogs.entrySet().stream()
                // Only want Dogs, so key is true
                .filter((s) -> s.getKey())
                // Flatten list of Pets to a Stream
                .flatMap(s -> s.getValue().stream())
                .limit(5)
                .forEach(System.out::println);

        System.out.println("--- Group by Pet using groupingBy ---");
        // Take list of Pet, collect into a Map using groupingBy
        // chain to stream of Entry and print key,values.
        petPopulation.stream()
                .collect(
                        // groupingBy with a single argument
                        Collectors.groupingBy(Pet::getType))
                .entrySet()
                .stream()
                .forEach(System.out::println);

        System.out.println("--- Group by Pet using toMap ---");
        // Take list of Pet, collect into a Map using toMap
        // chain to stream of Entry and print key,values.
        petPopulation.stream()
                .collect(
                        // toMap requires at least 2 arguments
                        Collectors.toMap(Pet::getType, p -> p))
                .entrySet()
                .stream()
                .forEach(System.out::println);
    }
}