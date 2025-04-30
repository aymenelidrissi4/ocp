package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class SimpleReductionExamples {

    public static void main(String[] args) {
        // Example data - list of words
        List<String> words = Arrays.asList("Java", "Stream", "API", "Reduction", "Examples");
        
        // 1. Basic reduction - concatenate words with space
        Optional<String> concatenated = words.stream()
                                          .reduce((s1, s2) -> s1 + " " + s2);
        System.out.println("Concatenated words: " + concatenated.orElse("empty"));

        // 2. Reduction with identity/initial value
        String withPrefix = words.stream()
                              .reduce("Words:", (s1, s2) -> s1 + " " + s2);
        System.out.println("With prefix: " + withPrefix);

        // 3. Parallel reduction with combiner
        String parallelResult = words.parallelStream()
                                 .reduce("", 
                                        (s1, s2) -> s1 + " " + s2, 
                                        (s1, s2) -> s1 + s2);
        System.out.println("Parallel result: " + parallelResult.trim());

        // 4. Number reductions
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Different ways to sum numbers
        int sum1 = IntStream.of(numbers).sum();
        int sum2 = IntStream.of(numbers).reduce(0, Integer::sum);
        int sum3 = IntStream.of(numbers).reduce(0, (a, b) -> a + b);
        
        System.out.println("\nSum results (all equal):");
        System.out.println("sum() method: " + sum1);
        System.out.println("reduce with method reference: " + sum2);
        System.out.println("reduce with lambda: " + sum3);

        // 5. Finding max/min with reduce
        Optional<String> longestWord = words.stream()
                                        .reduce((s1, s2) -> 
                                            s1.length() > s2.length() ? s1 : s2);
        System.out.println("\nLongest word: " + longestWord.orElse("none"));
    }
}