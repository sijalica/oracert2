package part8concurent;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using CyclicBarrier
*/

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) throws Exception {

        // Construct a CyclicBarrier,
        // First arg # of parties (tasks)
        // Second arg Action is a Runnable
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                () -> {
                    System.out.println("Confirming step is complete");
                });

        // Set up a callable local variable
        Callable<Boolean> r = () -> {

            // All threads execute step 1
            step(1);
            cyclicBarrier.await();

            // All threads execute step 2
            step(2);

            return true;
        };

        // Fixed Threads = Will be parties on CyclicBarrier
        ExecutorService service = Executors.newFixedThreadPool(4);
        // Invoke four callable tasks, all the same
        service.invokeAll(List.of(r, r, r, r));

        System.out.println("Shutting service down");
        service.shutdown();

    }

    public static void step(int stepNo) throws Exception {
        int ms = new Random().nextInt(5) * 1000;
        System.out.println(Thread.currentThread().getName() +
                " waiting for " + ms + " milliseconds to start step " + stepNo);
        Thread.sleep(ms);

        System.out.println(Thread.currentThread().getName() +
                " completed step " + stepNo);

    }

}