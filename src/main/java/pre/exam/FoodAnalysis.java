package pre.exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FoodAnalysis {
    public record Food(String name, int calories) {}

    public static void main(String[] args) {
        List<Food> menu = Arrays.asList(
            new Food("Apple", 200),
            new Food("Apple", 200),
            new Food("Banana", 400),
            new Food("Cake", 800),
            new Food("Cake", 900),
            new Food("Donut", 700),
            new Food("Donut", 600)
        );

        menu.stream()
            .collect(Collectors.groupingBy(
                Food::name,
                Collectors.averagingDouble(Food::calories)
            ))
            .entrySet().stream()
            .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
            .forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
    }
}