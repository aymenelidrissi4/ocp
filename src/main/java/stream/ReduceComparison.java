package stream;

import java.util.Arrays;
import java.util.List;

public class ReduceComparison {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int identity = 1; // Proper identity for addition

        // SEQUENTIAL REDUCE
        int seqResult = numbers.stream()
            .reduce(
                identity,
                (a, b) -> {
                    System.out.println(Thread.currentThread().getName() + 
                                   " accumulating: " + a + " + " + b);
                    return a + b;
                }
            );
        System.out.println("Sequential result: " + seqResult);
        System.out.println("---------------------------------------------------------");

        // PARALLEL REDUCE
        int parallelResult = numbers.parallelStream()
            .reduce(
                identity,
                (a, b) -> {
                    System.out.println(Thread.currentThread().getName() + 
                                     " accumulating: " + a + " + " + b);
                    return a + b;
                },
                (a, b) -> {
                    System.out.println(Thread.currentThread().getName() + 
                                     " combining: " + a + " + " + b);
                    return a + b;
                }
            );
        System.out.println("Parallel result: " + parallelResult);
    }
}