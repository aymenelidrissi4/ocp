package pre.exam;

import java.util.*;
import java.util.stream.Collectors;

public class VowelFilterExample {
    public static void main(String[] args) {
        List<String> source = Arrays.asList(
            new String[]{"Banana", "Carrot", "Apple", "Onion",
                         "Pineapple", "Soy", "Potato", null});

        Map<Long, List<String>> words = source.stream()
            .filter(s -> s != null)
            .sorted()
            .collect(
                Collectors.groupingBy( s -> (s == null) ? 0 :
                     s.toLowerCase().chars()
                        .filter(i -> i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u')
                        .count(),
                    Collectors.filtering(
                        s -> s.charAt(0) != 'P',
                        Collectors.toList()
                    )
                )
            );

        System.out.println(words);
    }
}