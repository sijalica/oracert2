package part8concurent;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Collect and Reduce
*/

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParallelExtras {
    public static void main(String[] args) {

        Set<String> set = new TreeSet<>(Set.of("b", "c", "d"));

        // Using reduce with String
        String firstResult = set
                .parallelStream()
                .reduce(String::concat)
                // reduce returns Optional,
                // need to use get() to get value
                .get();

        System.out.println("firstResult = " + firstResult);

        // Using collect with String
        String secondResult = set
                .parallelStream()
                // collect requires Collector argument
                .collect(Collectors.joining());

        System.out.println("secondResult = " + secondResult);
    }
}