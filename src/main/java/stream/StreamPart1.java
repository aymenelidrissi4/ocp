package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class Product {
    private double price;
    private double discount;

    // Constructors, getters, setters
    public Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

class Food extends Product1 {
    public Food() {
        super(5.0);
    }
}

class Drink extends Product1 {
    public Drink() {
        super(3.0);
    }
}

public class StreamPart1 {
    public static void main(String[] args) throws IOException {
//        // ===== 1. Basic Stream Creation =====
//        System.out.println("\n1. Basic Stream Creation:");
//        List<String> names = List.of("Alice", "Bob");
//        Stream<String> listStream = names.stream();
//        listStream.forEach(System.out::println);
//
//        // ===== 2. Primitive Streams =====
//        System.out.println("\n2. Primitive Streams:");
//        IntStream.range(1, 5).forEach(System.out::println);  // 1-4
//        double sum = DoubleStream.of(1.1, 2.2).sum();
//        System.out.println("Sum: " + sum);
//
//        // ===== 3. Stream Operations =====
//        System.out.println("\n3. Stream Operations:");
//        List<Product> products = List.of(new Drink(), new Food());
//        products.stream()
//                .filter(p -> p.getPrice() > 2)
//                .forEach(p -> p.setDiscount(0.1));
//
//        // ===== 4. Parallel Streams =====
//        System.out.println("\n4. Parallel Streams:");
//        List<Product> productList = new ArrayList<>(products);
//        double parallelSum = productList.stream()
//                .parallel()
//                .mapToDouble(Product::getPrice)
//                .sum();
//        System.out.println("Parallel sum: " + parallelSum);
//
//        // ===== 5. Specialized Generators =====
//        System.out.println("\n5. Specialized Generators:");
//        // Random numbers
//        DoubleStream randomNumbers = new Random().doubles(3);
//        randomNumbers.forEach(d -> System.out.println("Random: " + d));
//
//        // File lines
//        Stream<String> fileLines = Files.lines(Paths.get("test.txt"));
//        System.out.println("File lines count: " + fileLines.count());
//
//        // String characters
//        String s = "hello";
//        s.chars().forEach(c -> System.out.print((char) c + " "));  // h e l l o
//        System.out.println();
//
//        // ===== 6. Infinite Streams =====
//        System.out.println("\n6. Infinite Streams:");
//        int result = IntStream.generate(() -> (int) (Math.random() * 10))
//                .takeWhile(n -> n != 3)
//                .sum();
//        System.out.println("Sum until 3: " + result);
//
//        // ===== 7. Array Stream Example from Image =====
//        System.out.println("\n7. Array Stream Example:");
//        Product[] productArray = {new Drink(), new Food()};
//        Arrays.stream(productArray)
//                .filter(p -> p.getPrice() > 2)
//                .forEach(p -> p.setDiscount(0.1));

        ///////////////////////////////////////
        int sum = IntStream.generate(() -> (int)(Math.random() * 10))
                .takeWhile(n -> n != 3)
                .sum();
        System.out.println("Sum until 3: " + sum);

        // 2. Collection/Array streams
        List<Product1> list = new ArrayList<>();
        list.add(new Drink());
        list.stream().parallel()
                .mapToDouble(Product1::getPrice)
                .sum();

        Product1[] array = {new Drink(), new Food()};
        Arrays.stream(array)
                .filter(p -> p.getPrice() > 2)
                .forEach(p -> p.setDiscount(0.1));

        // 3. String character streams
        String s = "some text";
        s.codePoints()
                .mapToObj(c -> String.valueOf((char)c))
                .forEach(System.out::println);

        // 4. Random numbers
        new Random().doubles(5).forEach(d -> System.out.println("Random: " + d));

        // 5. File lines
        Files.lines(Paths.get("test.txt")).limit(2).forEach(System.out::println);

    }
}