package stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class StreamFilteringDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // ===== 1. Basic Predicate Filtering =====
        System.out.println("=== Basic Filtering ===");
        Predicate<String> lengthFilter = s -> s.length() > 5;
        Predicate<String> startsWithAFilter = s -> s.startsWith("a");
        
        words.stream()
            .filter(lengthFilter)
            .forEach(s -> System.out.println("Long word: " + s));

        // ===== 2. Predicate Combinations =====
        System.out.println("\n=== Predicate Combinations ===");
        // Using and()
        words.stream()
            .filter(startsWithAFilter.and(lengthFilter))
            .forEach(s -> System.out.println("Long word starting with 'a': " + s));

        // Using or()
        words.stream()
            .filter(startsWithAFilter.or(s -> s.startsWith("b")))
            .forEach(s -> System.out.println("Word starts with 'a' or 'b': " + s));

        // Using negate()
        words.stream()
            .filter(lengthFilter.negate())
            .forEach(s -> System.out.println("Short word: " + s));

        // ===== 3. Static Predicate Methods =====
        System.out.println("\n=== Static Predicate Methods ===");
        // Using isEqual()
        String target = "cherry";
        words.stream()
            .filter(Predicate.isEqual(target))
            .forEach(s -> System.out.println("Found target word: " + s));

        // Using not()
        words.stream()
            .filter(Predicate.not(lengthFilter))
            .forEach(s -> System.out.println("Not a long word: " + s));

        // ===== 4. Number Filtering Examples =====
        System.out.println("\n=== Number Filtering ===");
        Predicate<Integer> evenFilter = n -> n % 2 == 0;
        Predicate<Integer> greaterThan5 = n -> n > 5;

        numbers.stream()
            .filter(evenFilter.and(greaterThan5))
            .forEach(n -> System.out.println("Even number > 5: " + n));

        // ===== 5. Complex Filter Pipeline =====
        System.out.println("\n=== Complex Pipeline ===");
        words.stream()
            .peek(s -> System.out.println("Original: " + s))
            .filter(lengthFilter)
            .peek(s -> System.out.println("After length filter: " + s))
            .filter(Predicate.not(startsWithAFilter))
            .forEach(s -> System.out.println("Final result: " + s));
    }
}