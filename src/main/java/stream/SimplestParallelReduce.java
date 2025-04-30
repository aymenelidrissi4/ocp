package stream;

import java.util.Arrays;
import java.util.List;

public class SimplestParallelReduce {
    public static void main(String[] args) {
        // 1. Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // 2. Parallel stream sum using reduce
        int sum = numbers.parallelStream()
                       .reduce(
                           0,              // Identity value
                           (a, b) -> a + b,       // Accumulator
                           (a, b) -> a + b        // Combiner
                       );
        
        // 3. Print result
        System.out.println("Sum: " + sum);  // Always 15
    }
}