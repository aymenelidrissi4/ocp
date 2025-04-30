package stream;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class CollectingAndThenExample {

    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(19.99, 29.99, 39.99, 49.99);

        // Example 1: Format average price as currency
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.UK);
        String avgPrice = prices.stream()
            .collect(collectingAndThen(
                averagingDouble(Double::doubleValue), // Calculate average
                fmt::format                          // Format as currency
            ));
        System.out.println("Average price: " + avgPrice); // £34.99

        // Example 2: Create unmodifiable list
        List<Double> unmodifiablePrices = prices.stream()
            .collect(collectingAndThen(
                toList(),                           // First collect to list
                Collections::unmodifiableList        // Then make unmodifiable
            ));
        // unmodifiablePrices.add(10.99); // Would throw UnsupportedOperationException

        // Example 3: Calculate and round average
        Long roundedAvg = prices.stream()
            .collect(collectingAndThen(
                averagingDouble(Double::doubleValue),
                Math::round
            ));
        System.out.println("Rounded average: " + roundedAvg); // 35
    }
}