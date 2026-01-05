package real.prep;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
//        List<String> elements = Arrays.asList("car", "truck", "car", "bicycle", "car", "truck", "motocycle");
//        Map<String, Long> map = elements.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        map.keySet().stream().sorted().forEach(k -> System.out.println(map.get(k)));
//        var list = List.of("Table", "Chair");
//        var result = list.parallelStream()
//                .reduce(list.parallelStream().reduce((l, p) -> l + p).get(), (n, m) -> n + m, String::concat);
//        System.out.println(result);


//        var list = List.of("Table", "Chair");
//
//        var identity = list.parallelStream()
//                .peek(s -> System.out.println("[inner stream] element: " + s))
//                .reduce((l, p) -> {
//                    System.out.println("[inner reduce] l = " + l + ", p = " + p);
//                    return l + p;
//                })
//                .get();
//
//        System.out.println("IDENTITY = " + identity);
//
//        var result = list.parallelStream()
//                .peek(s -> System.out.println("[outer stream] element: " + s))
//                .reduce(
//                        identity,
//                        (n, m) -> {
//                            System.out.println("[accumulator] n = " + n + ", m = " + m);
//                            return n + m;
//                        },
//                        (a, b) -> {
//                            System.out.println("[combiner] a = " + a + ", b = " + b);
//                            return a + b;
//                        }
//                );
//
//        System.out.println("RESULT = " + result);
//
//        Logger logger = Logger.getLogger("Test");
//        Stream<String> s1 = Stream.of("A", "B", "C", "B");
//        Stream<String> s2 = Stream.of("A", "D", "E");
//        Stream.concat(s1,s2).parallel().distinct().sorted().forEach(e->logger.log(Level.INFO, e));
//        Stream.of(3, 6, 9, 12, 15, 19, 21, 24, 27)
//                .takeWhile(s -> s % 3 == 0)
//                .dropWhile(s -> s % 2 == 0)
//                .limit(3).forEach(s -> System.out.println(s + " "));


//        Stream.of(3, 6, 9, 12, 15, 19, 21, 24, 27)
//                .peek(s -> System.out.println("[original] " + s))
//                .takeWhile(s -> {
//                    boolean keep = s % 3 == 0;
//                    System.out.println("[takeWhile] s=" + s + " keep=" + keep);
//                    return keep;
//                })
//                .peek(s -> System.out.println("[after takeWhile] " + s))
//                .dropWhile(s -> {
//                    boolean drop = s % 2 == 0;
//                    System.out.println("[dropWhile] s=" + s + " drop=" + drop);
//                    return drop;
//                })
//                .peek(s -> System.out.println("[after dropWhile] " + s))
//                .limit(3)
//                .forEach(s -> System.out.println("[final] " + s));

//        Map<String, BigDecimal> priceList = new HashMap<>();
//        priceList.put("Cake", BigDecimal.valueOf(3.99));
//        priceList.put("Cookie", BigDecimal.valueOf(1.99));
//        priceList.put("Candy", BigDecimal.valueOf(2.99));
//        priceList.put("Cookie", BigDecimal.valueOf(4.99));
//        priceList.entrySet().stream()
//                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
//                .forEach(e -> System.out.println(e +" "));

//        Integer[] values = {-4,-2,12,7};
//        Arrays.sort(values, (v1,v2) -> v1.toString().compareTo(v2.toString()));
//        System.out.println(Arrays.toString(values));

//        int a = 2;
//        int b = ~a;
//        int c = a^b;
//        boolean d = a < b & a > c++;
//        System.out.println(d + " " + c);
//        boolean e = a > b && a > c++;
//        System.out.println(e + " " + c);

        /*
        int x = Integer.valueOf("a", 16)-9;
        String y = "128";
        byte z = Boolean.valueOf(String.valueOf(x)) ?
         */

    }
}
