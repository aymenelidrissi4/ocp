package stream;

import java.util.*;
import java.util.stream.*;

public class SimpleStreamJoining {

    public static void main(String[] args) {
        // Sample data: Orders containing lists of item prices
        List<List<Double>> orders = List.of(
            List.of(19.99, 9.99),    // Order 1 items
            List.of(24.99, 19.99, 4.99), // Order 2 items
            List.of(9.99, 9.99, 19.99)   // Order 3 items
        );

        // Sample data: Item names mapped to prices (for filter example)
        Map<Double, String> priceToName = Map.of(
            19.99, "Tee",
            9.99, "Mug",
            24.99, "Hat",
            4.99, "Pen"
        );

        // Example 1: flatMap to process all items in all orders
        double totalTeeSales = orders.stream()
            .flatMap(List::stream) // Flatten all order streams
            .filter(price -> "Tee".equals(priceToName.get(price)))
            .mapToDouble(Double::doubleValue)
            .sum();
        System.out.println("Total Tee sales: $" + totalTeeSales);

        // Example 2: flatMapToDouble (primitive variant)
        double totalAllSales = orders.stream()
            .flatMapToDouble(order -> 
                order.stream().mapToDouble(Double::doubleValue))
            .sum();
        System.out.println("Total all sales: $" + totalAllSales);

        // Example 3: Stream.concat()
        Stream<String> vehicles1 = Stream.of("car", "truck");
        Stream<String> vehicles2 = Stream.of("motorcycle", "bicycle");
        System.out.println("Concatenated vehicles:");
        Stream.concat(vehicles1, vehicles2)
              .forEach(System.out::println);

        // Example 4: Combining operations
        System.out.println("All unique items in orders:");
        orders.stream()
            .flatMap(List::stream)
            .map(priceToName::get)
            .distinct()
            .sorted()
            .forEach(System.out::println);
    }
}