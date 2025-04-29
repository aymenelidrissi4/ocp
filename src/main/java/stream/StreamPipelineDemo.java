package stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamPipelineDemo {
    public static void main(String[] args) {
        // ===== 1. STREAM SOURCES =====
        System.out.println("=== Stream Sources ===");
        
        // From Collection
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Stream<String> collectionStream = names.stream();
        
        // From Array
        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> arrayStream = Arrays.stream(numbers);
        
        // From values
        Stream<String> valueStream = Stream.of("A", "B", "C");
        
        // From generator (infinite stream)
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
        
        // Primitive streams
        IntStream intStream = IntStream.range(1, 6);
        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);

        // ===== 2. INTERMEDIATE OPERATIONS =====
        System.out.println("\n=== Intermediate Operations ===");
        
        // filter(Predicate<T>)
        Stream<String> filtered = names.stream()
            .filter(name -> name.length() > 3);
        
        // map(Function<T,R>)
        Stream<Integer> nameLengths = names.stream()
            .map(String::length);
        
        // flatMap(Function<T,Stream<R>>)
        Stream<String> letters = names.stream()
            .flatMap(name -> Arrays.stream(name.split("")));
        
        // peek(Consumer<T>)
        Stream<String> peeked = names.stream()
            .peek(name -> System.out.println("Processing: " + name));
        
        // distinct()
        Stream<String> distinct = Stream.of("A", "B", "A", "C").distinct();
        
        // sorted()
        Stream<String> sorted = names.stream().sorted();
        
        // dropWhile(Predicate<T>) - Java 9+
        Stream<Integer> dropped = Stream.of(1, 2, 3, 4, 5, 1)
            .dropWhile(n -> n < 3);
        
        // takeWhile(Predicate<T>) - Java 9+
        Stream<Integer> taken = Stream.of(1, 2, 3, 4, 5, 1)
            .takeWhile(n -> n < 3);
        
        // skip() and limit()
        Stream<String> skippedLimited = names.stream()
            .skip(1)
            .limit(2);

        // ===== 3. TERMINAL OPERATIONS =====
        System.out.println("\n=== Terminal Operations ===");
        
        // forEach(Consumer<T>)
        names.stream().forEach(System.out::println);
        
        // collect(Collector<T,A,R>)
        List<String> collected = names.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());
        
        // count()
        long count = names.stream().count();
        
        // min()/max() with Comparator
        Optional<String> shortestName = names.stream()
            .min(Comparator.comparingInt(String::length));
        
        // sum() and average() - primitive streams only
        double sum = DoubleStream.of(1.1, 2.2, 3.3).sum();
        OptionalDouble average = IntStream.range(1, 6).average();
        
        // reduce(BinaryOperator<T>)
        Optional<Integer> product = Stream.of(1, 2, 3, 4)
            .reduce((a, b) -> a * b);
        
        // match operations
        boolean anyMatch = names.stream().anyMatch(name -> name.length() > 5);
        boolean allMatch = names.stream().allMatch(name -> name.length() > 2);
        boolean noneMatch = names.stream().noneMatch(name -> name.length() > 10);
        
        // find operations
        Optional<String> first = names.stream().findFirst();
        Optional<String> any = names.stream().findAny();

        // ===== 4. SHORT-CIRCUIT OPERATIONS =====
        System.out.println("\n=== Short-Circuit Operations ===");
        
        // Works with infinite streams
        Optional<Double> firstRandom = Stream.generate(Math::random)
            .filter(n -> n > 0.8)
            .findFirst();
            
        boolean hasEven = Stream.iterate(1, n -> n + 1)
            .anyMatch(n -> n % 2 == 0);

        // ===== 5. FUNCTIONAL INTERFACES =====
        System.out.println("\n=== Functional Interfaces ===");
        
        // Predicate (test)
        Predicate<String> lengthPredicate = s -> s.length() > 3;
        
        // Function (transform)
        Function<String, Integer> lengthFunction = String::length;
        
        // UnaryOperator (special Function)
        UnaryOperator<String> toUpper = String::toUpperCase;
        
        // Consumer (side-effect)
        Consumer<String> printer = System.out::println;
        
        // Supplier (generate)
        Supplier<Double> randomSupplier = Math::random;
    }
}