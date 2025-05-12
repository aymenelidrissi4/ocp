package stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorDemo {

    public static void main(String[] args) {
        // Example 1: Basic Spliterator usage
        System.out.println("=== Basic Spliterator Example ===");
        Spliterator<Integer> spliterator = new Random().ints(10, 0, 10).spliterator();
        
        // Process first element
        spliterator.tryAdvance(v -> System.out.print("First element: " + v + " | "));
        
        // Try to split
        Spliterator<Integer> splitSpliterator = spliterator.trySplit();
        
        if (splitSpliterator == null) {
            System.out.println("Splitting failed");
        } else {
            System.out.print("\nMain spliterator: ");
            spliterator.forEachRemaining(v -> System.out.print(v + " "));
            
            System.out.print("\nSplit spliterator: ");
            splitSpliterator.forEachRemaining(v -> System.out.print(v + " "));
        }

        // Example 2: Parallel processing
        System.out.println("\n\n=== Parallel Processing Example ===");
        Spliterator<Integer> parallelSpliterator = new Random().ints(20, 0, 100).spliterator();
        Spliterator<Integer> parallelSplit = parallelSpliterator.trySplit();
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            System.out.print("Thread 1: ");
            parallelSpliterator.forEachRemaining(v -> System.out.print(v + " "));
        });
        executor.submit(() -> {
            System.out.print("Thread 2: ");
            parallelSplit.forEachRemaining(v -> System.out.print(v + " "));
        });
        executor.shutdown();

        // Example 3: Convert Iterable to Stream
        System.out.println("\n\n=== Iterable to Stream ===");
        Iterable<String> breakfast = Arrays.asList("Toast", "Eggs", "Coffee");
        Stream<String> breakfastStream = StreamSupport.stream(breakfast.spliterator(), false);
        breakfastStream.forEach(System.out::println);

        // Example 4: Convert Iterator to Stream
        System.out.println("\n=== Iterator to Stream ===");
        Iterator<String> dinnerIterator = Arrays.asList("Steak", "Potatoes", "Wine").iterator();
        Spliterator<String> dinnerSpliterator = Spliterators.spliteratorUnknownSize(dinnerIterator, Spliterator.ORDERED);
        Stream<String> dinnerStream = StreamSupport.stream(dinnerSpliterator, false);
        dinnerStream.forEach(System.out::println);
    }
}