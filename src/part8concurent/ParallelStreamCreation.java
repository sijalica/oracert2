package part8concurent;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Develop the code that uses parallel stream
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamCreation {
    public static void main(String[] args) {
        // Create a list of integers, multiples of 1 to 20
        List<Integer> integerList = Stream.iterate(
                        1, (t) -> t <= 20, (t) -> t + 1)
                .collect(Collectors.toList());

        List<Integer> testList = new ArrayList<>();


        System.out.println("-----  Serial stream results -----");
        // Create stream from integerList
        for (int i = 0; i < 5; i++) {
            testList.stream()
                    .forEach(
                             (s) -> {
                                 testList.add(0, s);
                                 System.out.println(s);
                             }
                                     // System.out.print(s + " ")
                                    // integerList.add(0, s) -- concurrent modification exception

                    );
            System.out.println();
        }

        System.out.println("----- Apply parallel operator to stream -----");
        // Turn a stream to a parallel stream by using parallel intermediate
        // operation on the stream.
        for (int i = 0; i < 5; i++) {
            integerList.stream()
                    .parallel()
                    .forEach((s) -> System.out.print(s + " "));
            System.out.println();
        }

        System.out.println("----- Getting a parallel stream from List -----");
        // Create parallel stream from integerList using parallelStream() method
        for (int i = 0; i < 5; i++) {
            integerList.parallelStream()
                    .forEachOrdered((s) -> System.out.print(s + " "));
            System.out.println();
        }

        System.out.println("----- Using stateful lambda expression -----");
        List<Integer> unsynchList = Collections.synchronizedList(new ArrayList<>());
        //  Create parallel stream from integerList using parallelStream() method
        for (int i = 0; i < 5; i++) {
            unsynchList.clear();
            integerList
                    .parallelStream()
                    // stateful lambda expression
                    .forEach((s) -> unsynchList.add(0, s));
            System.out.println(unsynchList);

        }
    }
}