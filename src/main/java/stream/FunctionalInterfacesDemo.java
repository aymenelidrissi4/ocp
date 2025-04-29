package stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Product1 {
    private double price;
    private double discount;
    
    public Product1(double price) {
        this.price = price;
        this.discount = 0;
    }
    
    public double getPrice() { return price; }
    public double getDiscount() { return discount; }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void applyDiscount(double discount) { this.discount = discount; }
    public String getDescription() { return String.format("$%.2f (%.0f%% off)", price, discount*100); }
}

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        // ===== 1. PREDICATE (Filtering) =====
        System.out.println("=== Predicate Example ===");
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        
        List<Product1> products = Arrays.asList(
            new Product1(100), new Product1(200), new Product1(150)
        );
        
        products.stream()
               .filter(p -> p.getPrice() > 150) // Predicate lambda
               .forEach(p -> System.out.println("Expensive: " + p.getDescription()));

        // ===== 2. FUNCTION (Transformation) =====
        System.out.println("\n=== Function Example ===");
        Function<String, Integer> lengthFunc = String::length;
        System.out.println("'Hello' length: " + lengthFunc.apply("Hello")); // 5
        
        products.stream()
               .map(p -> p.getDescription()) // Function lambda
               .forEach(System.out::println);

        // ===== 3. UNARYOPERATOR (Same-type transformation) =====
        System.out.println("\n=== UnaryOperator Example ===");
        UnaryOperator<String> upperCase = String::toUpperCase;
        System.out.println(upperCase.apply("hello")); // HELLO
        
        // From image example:
        UnaryOperator<String> textConverter = s -> s.toUpperCase();
        System.out.println(textConverter.apply("stream")); // STREAM

        // ===== 4. CONSUMER (Side-effects) =====
        System.out.println("\n=== Consumer Example ===");
        Consumer<Product1> applyDiscount = p -> p.applyDiscount(0.1);
        Product1 p = new Product1(100);
        applyDiscount.accept(p);
        System.out.println("After discount: " + p.getDescription());
        
        // From image example:
        Consumer<String> textPrinter = s -> System.out.println(s);
        textPrinter.accept("Print this!");

        // ===== 5. SUPPLIER (Generation) =====
        System.out.println("\n=== Supplier Example ===");
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random: " + randomSupplier.get());
        
        // From image example:
        Supplier<String> textGenerator = () -> {
            Random random = new Random();
            StringBuilder txt = new StringBuilder(10);
            for (int i = 0; i < 10; i++) {
                txt.append((char)(random.nextInt(26) + 'a'));
            }
            return txt.toString();
        };
        
        // ===== COMBINED EXAMPLE (From Image) =====
        System.out.println("\n=== Combined Stream Example ===");
        Stream.generate(textGenerator)
             .limit(5)
             .map(textConverter)
             .forEach(textPrinter);
        
        // ===== 6. PRACTICAL STREAM PIPELINE =====
        System.out.println("\n=== Practical Pipeline ===");
        products.stream()
               .filter(prod -> prod.getDiscount() == 0) // Predicate
               .peek(prod -> prod.applyDiscount(0.15))  // Consumer (side-effect)
               .map(Product1::getDescription)            // Function
               .forEach(System.out::println);           // Consumer
    }
}