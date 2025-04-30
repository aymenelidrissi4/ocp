package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamCollectExamples {

    public static void main(String[] args) {
        // Sample data
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2, 3);

        // =================================================================
        // 1. Basic collect() with supplier, accumulator, combiner
        // =================================================================
        System.out.println("\n1. Basic collect():");
        
        // Collect to ArrayList manually
        List<String> collectedList = names.stream()
            .collect(
                ArrayList::new,      // Supplier - creates container
                ArrayList::add,      // Accumulator - adds elements
                ArrayList::addAll    // Combiner - merges containers
            );
        System.out.println("Manually collected list: " + collectedList);

        // =================================================================
        // 2. Using Collectors utility class
        // =================================================================
        System.out.println("\n2. Collectors utility examples:");
        
        // 2.1 To List
        List<String> toList = names.stream()
            .collect(toList());
        System.out.println("toList(): " + toList);
        
        // 2.2 To Set (removes duplicates)
        Set<Integer> toSet = numbers.stream()
            .collect(toSet());
        System.out.println("toSet(): " + toSet);
        
        // 2.3 Joining strings
        String joined = names.stream()
            .collect(joining(", "));
        System.out.println("joining(): " + joined);
        
        // 2.4 Counting elements
        Long count = names.stream()
            .collect(counting());
        System.out.println("counting(): " + count);

        // =================================================================
        // 3. Advanced Collectors
        // =================================================================
        System.out.println("\n3. Advanced collectors:");
        
        // 3.1 Grouping by length
        Map<Integer, List<String>> byLength = names.stream()
            .collect(groupingBy(String::length));
        System.out.println("groupingBy(): " + byLength);
        
        // 3.2 Partitioning (true/false groups)
        Map<Boolean, List<String>> shortNames = names.stream()
            .collect(partitioningBy(s -> s.length() <= 3));
        System.out.println("partitioningBy(): " + shortNames);
        
        // 3.3 To Map
        Map<String, Integer> nameToLength = names.stream()
            .collect(toMap(
                Function.identity(),  // Key mapper (name itself)
                String::length        // Value mapper (name length)
            ));
        System.out.println("toMap(): " + nameToLength);

        // =================================================================
        // 4. CollectingAndThen (with finisher)
        // =================================================================
        System.out.println("\n4. CollectingAndThen examples:");
        
        // 4.1 Unmodifiable list
        List<String> unmodifiable = names.stream()
            .collect(collectingAndThen(
                toList(),
                Collections::unmodifiableList
            ));
        System.out.println("Unmodifiable list: " + unmodifiable.getClass());
        
        // 4.2 String with max length
        Optional<String> longestName = names.stream()
            .collect(collectingAndThen(
                maxBy(Comparator.comparingInt(String::length)),
                opt -> opt.map(s -> "The longest: " + s)
            ));
        System.out.println("Longest name: " + longestName.orElse("None"));

        // =================================================================
        // 5. Parallel collection
        // =================================================================
        System.out.println("\n5. Parallel collection:");
        
        List<String> parallelCollected = names.parallelStream()
            .collect(
                ArrayList::new,
                ArrayList::add,
                ArrayList::addAll
            );
        System.out.println("Parallel collected: " + parallelCollected);
    }
}