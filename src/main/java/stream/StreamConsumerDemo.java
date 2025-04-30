package stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamConsumerDemo {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("Apple", "Banana", "Cherry", "Date");

        // ===== 1. Basic Consumers =====
        Consumer<String> printItem = item -> System.out.println("Processing: " + item);
        Consumer<String> uppercaseItem = item -> System.out.println(item.toUpperCase());
        
        // Combined consumer
        Consumer<String> printAndUppercase = printItem.andThen(uppercaseItem);

        // ===== 2. forEach Examples =====
        System.out.println("=== forEach ===");
        items.stream().forEach(printAndUppercase);

        // Inline lambda version
        items.stream().forEach(item -> {
            System.out.println("Processing: " + item);
            System.out.println(item.toUpperCase());
        });

        // ===== 3. peek Examples =====
        System.out.println("\n=== peek ===");
        List<String> filtered = items.stream()
            .peek(item -> System.out.println("Before filter: " + item))
            .filter(item -> item.length() > 4)
            .peek(item -> System.out.println("After filter: " + item))
            .collect(Collectors.toList());

        // ===== 4. forEachOrdered =====
        System.out.println("\n=== forEachOrdered ===");
        items.parallelStream()
            .forEachOrdered(item -> System.out.println("Ordered: " + item));

        // ===== 5. Practical Example =====
        System.out.println("\n=== Practical Pipeline ===");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Track processing steps
        numbers.stream()
            .peek(n -> System.out.println("Original: " + n))
            .map(n -> n * 2)
            .peek(n -> System.out.println("Doubled: " + n))
            .filter(n -> n > 5)
            .forEach(n -> System.out.println("Final: " + n));
    }
}