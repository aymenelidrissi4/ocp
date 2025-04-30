package stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PrimitiveSupplierExamples {
    public static void main(String[] args) {
        // ===== Example 1: IntStream with takeWhile =====
        System.out.println("=== Random Int Stream (until 3) ===");
        int sumUntil3 = IntStream.generate(() -> (int)(Math.random() * 10)) // (1) Generate 0-9
                               .takeWhile(n -> n != 3)                     // (2) Stop at 3
                               .sum();                                     // (3) Sum values
        System.out.println("Sum before 3: " + sumUntil3);

        // ===== Example 2: Random doubles to ints =====
        System.out.println("\n=== Random Doubles to Ints ===");
        Random random = new Random();
        int sumOfRounded = random.doubles(10)                  // (1) 10 doubles (0-1)
                                .mapToInt(n -> (int)(Math.round(n * 100))) // (2) Scale to 0-100
                                .sum();                         // (3) Sum
        System.out.println("Sum of scaled values: " + sumOfRounded);

        // ===== Example 3: BooleanSupplier =====
        System.out.println("\n=== Boolean Supplier ===");
        BooleanSupplier boolSup = () -> "Cake".length() > 3;
        System.out.println("Is 'Cake' longer than 3? " + boolSup.getAsBoolean()); // true

        // ===== Additional Demonstration =====
        System.out.println("\n=== Stream Pipeline Breakdown ===");
        System.out.println("Random numbers until 3:");
        IntStream.generate(() -> (int)(Math.random() * 10))
                .takeWhile(n -> n != 3)
                .forEach(n -> System.out.print(n + " "));
    }
}