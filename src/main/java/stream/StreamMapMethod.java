package stream;

import java.util.*;
import java.util.stream.*;

public class StreamMapMethod {

    public static void main(String[] args) {

        // Example 1: mapToInt - Get length of each word
        List<String> words = Arrays.asList("Java", "Stream", "Map");

        // Convert Stream<String> to IntStream of lengths
        IntStream lengths = words.stream()
                                 .mapToInt(String::length);

        System.out.println("Word lengths:");
        lengths.forEach(System.out::println);  // prints: 4, 6, 3


        // Example 2: mapToObj - Convert numbers to string labels
        IntStream numbers = IntStream.of(1, 2, 3);

        // Convert IntStream to Stream<String>
        Stream<String> labels = numbers.mapToObj(n -> "Number: " + n);

        System.out.println("Number labels:");
        labels.forEach(System.out::println);  // prints: Number: 1, etc.
    }
}
