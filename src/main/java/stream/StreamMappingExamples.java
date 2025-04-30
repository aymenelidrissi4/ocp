package stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class StreamMappingExamples {

    public static void main(String[] args) {
        // Sample data
        List<String> strings = List.of("  apple  ", " banana ", "  cherry  ");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Example 1: Basic mapping with String operations
        Function<String, String> trimMapper = String::trim;
        UnaryOperator<String> upperCaseMapper = String::toUpperCase;
        ToIntFunction<String> lengthMapper = String::length;

        int totalLength = strings.stream()
                .map(trimMapper.andThen(upperCaseMapper))
                .mapToInt(lengthMapper)
                .sum();
        System.out.println("Total length of trimmed strings: " + totalLength);

        // Example 2: Concise alternative
        int conciseTotalLength = strings.stream()
                .mapToInt(s -> s.trim().toUpperCase().length())
                .sum();
        System.out.println("Concise total length: " + conciseTotalLength);

        // Example 3: Number transformations
        numbers.stream()
                .map(n -> n * 2)  // Double each number
                .map(String::valueOf)  // Convert to string
                .forEach(System.out::println);

        // Example 4: Primitive to object mapping
        IntStream.range(1, 5)
                .mapToObj(Integer::toBinaryString)
                .forEach(System.out::println);

        // Example 5: Function composition with andThen vs compose
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> plusThree = x -> x + 3;

        // andThen: timesTwo then plusThree (2*2 + 3 = 7)
        System.out.println("andThen result: " + timesTwo.andThen(plusThree).apply(2));

        // compose: plusThree then timesTwo (2+3 * 2 = 10)
        System.out.println("compose result: " + timesTwo.compose(plusThree).apply(2));

        // Example 6: Using identity function
        Function<String, String> identity = Function.identity();
        strings.stream()
                .map(identity)
                .forEach(System.out::println);
    }
}