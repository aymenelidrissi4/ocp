package pre.exam;

import java.util.*;
import java.util.concurrent.*;

public class SynchronizedListExample {
    public static void main(String[] args) {
        // Create a synchronized (thread-safe) ArrayList
        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());

        // Create a Callable task that adds numbers 0-4 to the list
        Callable<String> c = () -> {
            for (int i = 0; i < 5; i++) {
                nums.add(i);
            }
            return null;
        };

        // Create a collection with 3 copies of the same task
        Collection<Callable<String>> tasks = List.of(c, c, c);

        // Create a thread pool with 2 threads
        ExecutorService es = Executors.newFixedThreadPool(2);

        try {
            // Execute all tasks and wait for them to complete
            List<Future<String>> results = es.invokeAll(tasks);
            es.shutdown();
            
            // Print all elements in the list
            nums.stream().forEach(i -> System.out.print(i));
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}