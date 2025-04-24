package collections;

import java.util.ArrayList;
import java.util.List;

public class ListSample {
    public static void main(String[] args) {
//        Product p1 = new Food("Cake");
//        Product p2 = new Drink("Tea");
//
//        List<Product> menu = new ArrayList<>();
//        menu.add(p1);
//        menu.add(p2);
//        System.out.println(menu);
//        menu.add(2, null);
//        System.out.println(menu);
//        menu.add(3, p1);
//        System.out.println(menu);
//        menu.add(2, p1);
//        System.out.println(menu);
//        menu.set(2, new Product("new"));
//        System.out.println(menu);
//        menu.remove(0);
//        System.out.println(menu);
//        menu.add(p2);
//        System.out.println(menu);
//        menu.remove(p2);
//        System.out.println(menu);
//        menu.remove(p2);
//        System.out.println(menu);
//        boolean hasTea = menu.contains(p2);
//        System.out.println(hasTea);
//        System.out.println(menu.get(menu.indexOf(p1)));
//        menu.add(4  , p2);//exception
//        System.out.println(menu);
//
//        Set<Product> set = new HashSet<>();
//        set.add(p1);
//        set.add(p2);
//        System.out.println(set);
//
//        LinkedList<String> pets = new LinkedList<>();
//        pets.add("dog");
//        pets.add("cat");
//        pets.add("fish");
//        System.out.println("LinkedList : " + pets);
//
//        List<Product> list1 = new ArrayList<>();
//        List<Product> list2 = new ArrayList<>(20);
//        List<Product> list3 = new ArrayList<>(set);
//        List<Product> list4 = Arrays.asList(p1, p2);
//        List<Product> list5 = List.of(p1, p2);
////        list4.add(new Drink("pulpy"));//unsupported operation(fixedsize)
////        list5.add(new Drink("pulpy"));//unsupported operation(readonly)
//        System.out.println(list4);
//        System.out.println(list5);
        String txt1 = """
         \tHello
        World
        """;
        System.out.println(txt1.indexOf("o", 7));
    }
}
