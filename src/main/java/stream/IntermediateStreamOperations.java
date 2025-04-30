package stream;

import java.util.Arrays;
import java.util.List;

public class IntermediateStreamOperations {

    public static void main(String[] args) {
        // Example 1: distinct(), sorted(), skip()
        System.out.println("Example 1 - distinct, sorted, skip:");
        List<Integer> numbers = Arrays.asList(3, 4, 2, 1, 4, 5, 1);
        numbers.stream()
              .distinct()    // Remove duplicates (1, 2, 3, 4, 5)
              .sorted()      // Sort naturally (1, 2, 3, 4, 5)
              .skip(2)      // Skip first 2 elements (3, 4, 5)
              .forEach(System.out::println);

        // Example 2: takeWhile(), dropWhile(), limit()
        System.out.println("\nExample 2 - takeWhile, dropWhile, limit:");
        List<String> letters = Arrays.asList("B", "C", "A", "E", "D", "F");
        letters.stream()
              .takeWhile(s -> !s.equals("D"))  // Take until "D" is found (B, C, A, E)
              .dropWhile(s -> !s.equals("C"))  // Drop until "C" is found (C, A, E)
              .limit(2)                       // Limit to 2 elements (C, A)
              .forEach(System.out::println);

        // Additional examples to demonstrate all operations
        System.out.println("\nAdditional Examples:");

        // distinct() with strings
        System.out.println("distinct():");
        Arrays.asList("apple", "orange", "apple", "banana").stream()
              .distinct()
              .forEach(System.out::println);

        // sorted() with custom comparator
        System.out.println("\nsorted(Comparator.reverseOrder()):");
        Arrays.asList(5, 2, 8, 1).stream()
              .sorted(java.util.Comparator.reverseOrder())
              .forEach(System.out::println);

        // limit()
        System.out.println("\nlimit(3):");
        Arrays.asList(1, 2, 3, 4, 5).stream()
              .limit(3)
              .forEach(System.out::println);

        // takeWhile() vs. filter() - important difference!
        System.out.println("\ntakeWhile() stops at first non-matching element:");
        Arrays.asList(2, 4, 6, 7, 8, 9, 10).stream()
              .takeWhile(n -> n % 2 == 0)  // Stops at 7
              .forEach(System.out::println);

        System.out.println("\nfilter() processes all elements:");
        Arrays.asList(2, 4, 6, 7, 8, 9, 10).stream()
              .filter(n -> n % 2 == 0)  // Processes all
              .forEach(System.out::println);
    }
}