package stream;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;

public class StreamExample {

    public static void main(String[] args) {

        // Supplier Example
        Supplier<String> supplier = () -> "Hello from Supplier!";
        System.out.println(supplier.get());

        // Consumer Example
        Consumer<String> consumer = message -> System.out.println("Message: " + message);
        consumer.accept("Hello Consumer!");

        // Function Example
        Function<Integer, String> function = number -> "Number is " + number;
        System.out.println(function.apply(5));

        // UnaryOperator Example
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(4)); // 4*4 = 16

        // Predicate Example
        Predicate<String> predicate = str -> str.isEmpty();
        System.out.println(predicate.test(""));      // true
        System.out.println(predicate.test("hello")); // false
    }
}
