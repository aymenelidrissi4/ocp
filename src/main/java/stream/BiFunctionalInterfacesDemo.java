package stream;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

class Product2 {
    private String name;
    private BigDecimal price;

    public Product2(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
}

class Food3 extends Product2 {
    public Food3(String name, BigDecimal price) {
        super(name, price);
    }
}

class Drink3 extends Product2 {
    public Drink3(String name, BigDecimal price) {
        super(name, price);
    }
}

public class BiFunctionalInterfacesDemo {
    public static void main(String[] args) {
        // ===== 1. BiConsumer Example (from image) =====
        System.out.println("=== BiConsumer Example (Map.forEach) ===");
        Product2 p1 = new Food3("Cake", BigDecimal.valueOf(3.10));
        Product2 p2 = new Drink3("Tea", BigDecimal.valueOf(1.20));

        Map<Product2, Integer> items = new HashMap<>();
        items.put(p1, 1);
        items.put(p2, 3);

        // Original example from image
        items.forEach((product, quantity) -> {
            BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            System.out.println(product.getName() + " total: " + total);
        });

        // ===== 2. BiPredicate Example =====
        System.out.println("\n=== BiPredicate Example ===");
        BiPredicate<String, Integer> nameLengthCheck = (name, maxLen) -> name.length() <= maxLen;
        System.out.println("Is 'Alice' <= 5 chars? " + nameLengthCheck.test("Alice", 5)); // true
        System.out.println("Is 'Christopher' <= 5 chars? " + nameLengthCheck.test("Christopher", 5)); // false

        // ===== 3. BiFunction Example =====
        System.out.println("\n=== BiFunction Example ===");
        BiFunction<Double, Double, String> powerToString = (base, exp) -> 
            String.valueOf(Math.pow(base, exp));
        System.out.println("2^3 = " + powerToString.apply(2.0, 3.0)); // "8.0"

        // ===== 4. BinaryOperator Example =====
        System.out.println("\n=== BinaryOperator Example ===");
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println("5 + 3 = " + sum.apply(5, 3)); // 8

        // Primitive variant
        IntBinaryOperator intSum = (a, b) -> a + b;
        System.out.println("Int sum: " + intSum.applyAsInt(10, 20)); // 30

        // ===== 5. ObjIntConsumer Example =====
        System.out.println("\n=== ObjIntConsumer Example ===");
        ObjIntConsumer<String> repeatPrinter = (str, times) -> {
            System.out.println("Printing '" + str + "' " + times + " times:");
            for (int i = 0; i < times; i++) {
                System.out.println(str);
            }
        };
        repeatPrinter.accept("Hello", 3);

        // ===== 6. ToIntBiFunction Example =====
        System.out.println("\n=== ToIntBiFunction Example ===");
        ToIntBiFunction<String, String> combinedLength = (s1, s2) -> s1.length() + s2.length();
        int totalLength = combinedLength.applyAsInt("Java", "Streams");
        System.out.println("Combined length: " + totalLength); // 11
    }
}