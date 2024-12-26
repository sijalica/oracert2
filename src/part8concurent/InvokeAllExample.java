package part8concurent;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using ExecutorService, InvokeAll method
*/

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class InvokeAllExample {

    public static void main(String[] args) {

        // Create a collection of Callable lambda expressions
        Collection<Callable<IntSummaryStatistics>> tasks = List.of(
                () -> InvokeAllExample
                        .doSomething(1, 1111),
                () -> InvokeAllExample
                        .doSomething(5, 5000),
                () -> InvokeAllExample
                        .doSomething(7, 100),
                () -> InvokeAllExample
                        .doSomething(100, 10000)
        );

        ExecutorService executorService = null;

        // Following variable will hold results
        List<Future<IntSummaryStatistics>> results = null;

        try {
            executorService = Executors.newSingleThreadExecutor();

            // Pass all tasks to ExecutorService
            results = executorService.invokeAll(tasks);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    // Wait no longer than 2 seconds for completion confirmation
                    executorService.awaitTermination(2, TimeUnit.SECONDS);

                    if (results != null) {
                        // Print out results of each task
                        for (Future<IntSummaryStatistics> f : results) {
                            System.out.println(f);
                            System.out.println(f.get());
                        }
                    }

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private static IntSummaryStatistics doSomething(int seed, int limit) {
        return Stream.iterate(seed, (t) -> t + seed)
                .limit(limit)
                .mapToInt((s) -> s)
                .summaryStatistics();

    }
}