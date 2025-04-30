package stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class GroupingWithFlatMap {

    // Simple record classes for example
    record Product(String name) {}
    record Order(String customer, LocalDate date, List<Product> items) {}

    public static void main(String[] args) {
        // Sample data
        List<Order> orders = List.of(
            new Order("Joe", LocalDate.of(2023, 11, 22), 
                     List.of(new Product("Tea"), new Product("Coffee"))),
            new Order("Joe", LocalDate.of(2023, 11, 23), 
                     List.of(new Product("Cake"))),
            new Order("Bob", LocalDate.of(2023, 11, 22), 
                     List.of(new Product("Coffee")))
        );

        // =============================================
        // 1. flatMapping - Flatten products per customer
        // =============================================
        Map<String, Set<Product>> customerProducts = orders.stream()
            .collect(groupingBy(
                Order::customer,
                flatMapping(order -> order.items().stream(), toSet())
            ));
        
        System.out.println("All products by customer (flatMapping):");
        // {Joe=[Tea, Coffee, Cake], Bob=[Coffee]}
        customerProducts.forEach((k,v) -> System.out.println(k + ": " + v));

        // =============================================
        // 2. filtering - Filter orders within groups
        // =============================================
        LocalDate targetDate = LocalDate.of(2023, 11, 22);
        Map<String, Set<Order>> ordersOnDate = orders.stream()
            .collect(groupingBy(
                Order::customer,
                filtering(order -> order.date().equals(targetDate), toSet())
            ));
        
        System.out.println("\nOrders on 2023-11-22 by customer (filtering):");
        // {Joe=[Order[customer=Joe, date=2023-11-22...]], Bob=[Order[...]]}
        ordersOnDate.forEach((k,v) -> System.out.println(k + ": " + v));

        // =============================================
        // 3. Comparison with regular mapping
        // =============================================
        Map<String, Set<List<Product>>> customerOrderedProducts = orders.stream()
            .collect(groupingBy(
                Order::customer,
                mapping(Order::items, toSet())
            ));
        
        System.out.println("\nProducts by customer (regular mapping):");
        // {Joe=[[Tea, Coffee], [Cake]], Bob=[[Coffee]]}
        customerOrderedProducts.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}