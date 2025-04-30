package stream;

import java.util.Arrays;
import java.util.List;

public class ForEachVsForEachOrdered {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");

        System.out.println("=== Parallel Stream with forEach ===");
        fruits.parallelStream()
              .forEach(item -> System.out.println("Processing: " + item));

        System.out.println("\n=== Parallel Stream with forEachOrdered ===");
        fruits.parallelStream()
              .forEachOrdered(item -> System.out.println("Processing: " + item));
    }
}