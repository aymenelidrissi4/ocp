package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class BasicCollectorsExamples {

    public static void main(String[] args) {
        // Sample data
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<Double> prices = Arrays.asList(1.99, 2.99, 1.49, 3.99, 2.49);

        // 1. Calculating summary statistics
        System.out.println("=== Summary Statistics ===");
        DoubleSummaryStatistics stats = prices.stream()
            .collect(summarizingDouble(Double::doubleValue));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());

        // 2. Mapping and joining elements
        System.out.println("\n=== Mapping and Joining ===");
        String joined = words.stream()
            .collect(mapping(String::toUpperCase, joining(", ")));
        System.out.println("Joined: " + joined);

        // 3. Filtering and collecting to list
        System.out.println("\n=== Filtering and Collecting ===");
        List<String> longWords = words.stream()
            .filter(w -> w.length() > 5)
            .collect(toList());
        System.out.println("Long words: " + longWords);

        // 4. Grouping by criteria
        System.out.println("\n=== Grouping By ===");
        Map<Integer, List<String>> wordsByLength = words.stream()
            .collect(groupingBy(String::length));
        System.out.println("Words by length: " + wordsByLength);

        // 5. Partitioning
        System.out.println("\n=== Partitioning ===");
        Map<Boolean, List<String>> partitioned = words.stream()
            .collect(partitioningBy(w -> w.length() > 5));
        System.out.println("Short vs long words: " + partitioned);

        // 6. Counting occurrences
        System.out.println("\n=== Counting ===");
        Map<String, Long> countByWord = words.stream()
            .collect(groupingBy(Function.identity(), counting()));
        System.out.println("Word counts: " + countByWord);
    }
}