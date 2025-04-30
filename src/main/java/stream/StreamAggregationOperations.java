package stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class StreamAggregationOperations {

    public static void main(String[] args) {
        // Sample data
        String[] colors = {"RED", "GREEN", "BLUE"};
        
        // 1. count() - returns number of elements
        long count = Arrays.stream(colors)
                         .filter(s -> s.contains("R"))
                         .count();
        System.out.println("Number of colors containing 'R': " + count);
        
        // 2. sum() - available only for primitive streams
        int totalLength = Arrays.stream(colors)
                               .mapToInt(String::length)
                               .sum();
        System.out.println("Total length of all colors: " + totalLength);
        
        // 3. average() - returns OptionalDouble
        OptionalDouble avgLength = Arrays.stream(colors)
                                       .mapToInt(String::length)
                                       .average();
        System.out.println("Average color length: " + 
                          avgLength.orElse(0)); // Safe value if empty
        
        // 4. max() - returns Optional<T> using comparator
        Optional<String> maxColor = Arrays.stream(colors)
                                       .max((s1, s2) -> s1.compareTo(s2));
        System.out.println("Max color (alphabetical): " + 
                          maxColor.orElse("no data"));
        
        // 5. min() - returns Optional<T> using comparator
        Optional<String> minColor = Arrays.stream(colors)
                                       .min((s1, s2) -> s1.compareTo(s2));
        System.out.println("Min color (alphabetical): " + 
                          minColor.orElse("no data"));
        
        // Additional examples with numbers
        int[] numbers = {5, 2, 8, 1, 9, 3};
        
        System.out.println("\nNumber operations:");
        System.out.println("Count: " + Arrays.stream(numbers).count());
        System.out.println("Sum: " + Arrays.stream(numbers).sum());
        System.out.println("Average: " + 
                         Arrays.stream(numbers).average().orElse(0));
        System.out.println("Max: " + 
                         Arrays.stream(numbers).max().orElse(0));
        System.out.println("Min: " + 
                         Arrays.stream(numbers).min().orElse(0));
        
        // Working with Optional properly
        OptionalInt emptyOptional = Arrays.stream(new int[0]).max();
        System.out.println("\nEmpty Optional handling:");
        System.out.println("Is present: " + emptyOptional.isPresent());
        System.out.println("Value or default: " + emptyOptional.orElse(-1));
    }
}