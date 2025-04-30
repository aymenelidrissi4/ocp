package stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamWithCustomThreads {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Create a ForkJoinPool with 4 threads
        ForkJoinPool customThreadPool = new ForkJoinPool(2);

        try {
            int sum = customThreadPool.submit(() ->
                list.parallelStream()
                    .reduce(
                            2,              // Identity value
                            (a, b) -> a + b,         // Combiner
                            (a, b) -> a + b         // Combiner
                    )
            ).get();
            System.out.println(sum);
            // .get() waits for completion
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
