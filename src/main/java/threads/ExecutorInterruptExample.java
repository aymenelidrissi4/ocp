package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorInterruptExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " is running...");
                    Thread.sleep(1000);  // Simulate some work
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted during execution.");
            } finally {
                System.out.println(Thread.currentThread().getName() + " is exiting.");
            }
        };

        // Submit the tasks
        executor.submit(task);
        executor.submit(task);

        // Allow tasks to run for 5 seconds
        Thread.sleep(5000);

        // Initiate shutdown and interrupt running threads
        System.out.println("Calling shutdownNow()...");
        executor.shutdownNow();
    }
}
