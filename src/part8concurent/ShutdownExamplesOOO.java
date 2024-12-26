package part8concurent;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  ExecutorService. Shutdown
*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ShutdownExamplesOOO {
    public static void main(String[] args) throws Exception {

        // Use a fixed thread pool service
        ExecutorService service = Executors.newFixedThreadPool(1);

        // Create a Runnable task
        Runnable task = () -> {
            try {
                System.out.println("Kicking off Runnable Hello");
                Thread.sleep(1000);
                System.out.println("Finishing Runnable Hello");
            } catch (InterruptedException e) {
                throw new RuntimeException("Runnable Hello", e);
            }
        };

        // Create a Callable task
        Callable<String> call = () -> {
            try {
                System.out.println("Kicking off Callable Hello");
                Thread.sleep(500);
                System.out.println("Finishing Callable Hello");
                return "Hello";
            } catch (InterruptedException e) {
                throw new RuntimeException("Callable Hello", e);
            }
        };

        // Use submit to submit a Runnable, second argument is returned
        // as result
        Future<String> future1 = service.submit(task, "Goodbye");

        // Use submit to submit a Callable, the result of the Callable
        // expression is returned.
        Future<String> future2 = service.submit(call);

        // Execute shutdown
        service.shutdown();

        // Print out future objects
        // Print out data in the Future object
        System.out.println("future1.get() = " + future1.get());
        System.out.println("future2.get() = " + future2.get());

    }
}