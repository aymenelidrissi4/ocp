package collections;

import java.util.*;

public class SetSample {
    public static void main(String[] args) {
        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");

        List<Product> menu = new ArrayList<>();
        menu.add(p1);
        menu.add(p2);

        Set<Product> set1 = new HashSet<>();
        Set<Product> set2 = new HashSet<>(20);
        Set<Product> set3 = new HashSet<>(20, 0.85f);
        Set<Product> set4 = new HashSet<>(menu);
        set4.add(null);
        Set<Product> set5 = Set.of(p1, p2);
//        set5.add(p2);//UnsupportedOperationException
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        System.out.println(set4);
        System.out.println(set5);

         TreeSet<String> set = new TreeSet<>();
         set.add("one");
         set.add("two");
         set.add("three");
         set.add("three");
         for (String item : set){
             System.out.println(item);
         }
         set.remove("one");
         set.add("four");
         set.add("five");
        System.out.println("first" + set.first());
        System.out.println(set.contains("two"));
        System.out.println(set);
        System.out.println(set.headSet("five"));
        System.out.println(set.tailSet("two"));


        // Create a TreeSet and add some elements
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(42);
        numbers.add(15);
        numbers.add(73);
        numbers.add(8);
        numbers.add(33);

        // TreeSet stores elements in ascending sorted order
        System.out.println("TreeSet: " + numbers);

        // Get the first (smallest) element
        int firstElement = numbers.first();
        System.out.println("First (smallest) element: " + firstElement);

        // Get the last (largest) element
        int lastElement = numbers.last();
        System.out.println("Last (largest) element: " + lastElement);
        System.out.println(numbers.ceiling(1));

    }
}
