package pre.exam;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.concat(IntStream.range(0, 3), IntStream.range(3, 7))
                .parallel()
                .sorted()
                .filter(i -> i < 5 && i > 1)
                .mapToObj(i -> String.valueOf(i))
                .forEach(s -> System.out.println(s));
    }
}