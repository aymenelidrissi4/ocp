package stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class GroupingPartitioningDemo {

    public static void main(String[] args) {
        // Sample data - orders with amounts and dates
        record Order(double amount, LocalDate date, boolean isPriority) {}
        
        List<Order> orders = Arrays.asList(
            new Order(100.0, LocalDate.of(2023, 3, 7), true),
            new Order(150.0, LocalDate.of(2023, 3, 7), false),
            new Order(200.0, LocalDate.of(2023, 3, 8), true),
            new Order(75.0, LocalDate.of(2023, 3, 14), false),
            new Order(300.0, LocalDate.of(2023, 3, 8), true)
        );

        // =============================================
        // 1. Partitioning - split by boolean condition
        // =============================================
        Map<Boolean, List<Order>> priorityOrders = orders.stream()
            .collect(partitioningBy(Order::isPriority));
        
        System.out.println("Priority orders (true/false):");
        priorityOrders.forEach((k,v) -> System.out.println(k + ": " + 
            v.stream().mapToDouble(Order::amount).sum()));

        // =============================================
        // 2. Grouping - categorize by date
        // =============================================
        Map<LocalDate, List<Order>> ordersByDate = orders.stream()
            .collect(groupingBy(Order::date));
        
        System.out.println("\nOrders grouped by date:");
        ordersByDate.forEach((date, orderList) -> 
            System.out.println(date + ": " + orderList.size() + " orders"));

        // =============================================
        // 3. Advanced Grouping - with downstream collector
        // =============================================
        Map<LocalDate, Double> totalByDate = orders.stream()
            .collect(groupingBy(
                Order::date,
                summingDouble(Order::amount)
            ));
        
        System.out.println("\nTotal amounts by date:");
        totalByDate.forEach((date, total) -> 
            System.out.println(date + ": $" + total));
    }
}