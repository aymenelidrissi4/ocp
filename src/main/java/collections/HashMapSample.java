package collections;

import java.util.*;

public class HashMapSample {
    public static void main(String[] args) {
//        Product p1 = new Food("Cake");
//        Product p2 = new Drink("Tea");
//        Product p3 = new Drink("Cookie");
//
//        Map<Product, Integer> items1 = new HashMap<>();
//        Map<Product, Integer> items2 = new HashMap<>(20);
//        Map<Product, Integer> items3 = new HashMap<>(20, 0.8f);
//        Map<Product, Integer> items4 = Map.of(new Food("Cake"), Integer.valueOf(2), new Food("Tea"), Integer.valueOf(3));
//        Map<Product, Integer> items5 = Map.ofEntries(Map.entry(new Food("Cake"), Integer.valueOf(2)),Map.entry(new Food("Tea"), Integer.valueOf(3)));
//        items4.put(new Food("Cookie"), Integer.valueOf(4));
//        items5.put(new Food("Cookie"), Integer.valueOf(4));

//
//        Product p1 = new Food("Cake");
//        Product p2 = new Drink("Tea");
//        Product p3 = new Drink("Cookie");
//
//        Map<Product, Integer> map = new HashMap<>();
//        map.put(p1, 1);
//        map.put(p2, 1);
//        Integer n1 = map.put(p1, 2);
//        Integer n2 = map.replace(p1, 3);
//        Integer rem = map.remove(p2);
//        Integer rem2 = map.remove(p3);
//        boolean hasTea =  map.containsKey(p2);
//        boolean hasTwo = map.containsValue(2);
//        System.out.println(map.get(p1));
//        System.out.println(map.get(p2));



        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");
        Product p3 = new Drink("Cookie");

        Map<Product, Integer> map = new HashMap<>();
        map.put(p1, 1);
        map.put(p2, 2);
        map.put(p3, 3);

        Set<Product> keys = map.keySet();
        Collection<Integer> values = map.values();

        for(Product product : keys){
            System.out.println(product);
        }


        for(Integer value : values){
            System.out.println(value);
        }

        Iterator<Product> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Product product = iterator.next();
            System.out.println(product);
            iterator.remove();
        }
    }
}
