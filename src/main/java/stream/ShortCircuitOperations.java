package stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class ShortCircuitOperations {

    public static void main(String[] args) {
        // Sample data
        String[] colors = {"RED", "GREEN", "BLUE"};
        
        // 1. allMatch() - checks if ALL elements match the predicate
        boolean allGreen = Arrays.stream(colors)
                               .allMatch(s -> s.equals("GREEN"));
        System.out.println("All colors are GREEN: " + allGreen); // false
        
        // 2. anyMatch() - checks if ANY element matches the predicate
        boolean anyGreen = Arrays.stream(colors)
                               .anyMatch(s -> s.equals("GREEN"));
        System.out.println("Any color is GREEN: " + anyGreen); // true
        
        // 3. noneMatch() - checks if NO elements match the predicate
        boolean noneGreen = Arrays.stream(colors)
                                .noneMatch(s -> s.equals("GREEN"));
        System.out.println("No colors are GREEN: " + noneGreen); // false
        
        // 4. findAny() - returns any element (non-deterministic in parallel streams)
        Optional<String> anyColor = Arrays.stream(colors).findAny();
        System.out.println("Any color: " + anyColor.orElse("N/A")); // RED (usually)
        
        // 5. findFirst() - returns the first element
        Optional<String> firstColor = Arrays.stream(colors).findFirst();
        System.out.println("First color: " + firstColor.orElse("N/A")); // RED
        
        // Demonstration with infinite stream
        System.out.println("\nWorking with infinite streams:");
        
        // This would run forever with a regular terminal operation
        // But short-circuit operations will terminate
        
        // Generate infinite stream of random numbers between 0-99
        Stream<Integer> infiniteNumbers = Stream.generate(() -> (int)(Math.random() * 100));
        
        // Check if any number > 90 (will stop when finds first match)
        boolean hasLargeNumber = infiniteNumbers.anyMatch(n -> n > 90);
        System.out.println("Stream contains number > 90: " + hasLargeNumber);
        
        // Note: We can't reuse the same infinite stream, need to create new one
        Stream<Integer> infiniteNumbers2 = Stream.generate(() -> (int)(Math.random() * 100));
        
        // Find first number > 95 (will stop when finds first match)
        Optional<Integer> firstLargeNumber = infiniteNumbers2.filter(n -> n > 95).findFirst();
        System.out.println("First number > 95: " + firstLargeNumber.orElse(-1));
    }
}