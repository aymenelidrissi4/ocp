package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOtherBehaviorSample {
    public static void main(String[] args) {
        List<Product> menu = new ArrayList<>();
        menu.add(new Food("cake"));
        menu.add(new Drink("tea"));
        menu.add(new Product("cookie"));


        Product[] array = new Product[2];
        array = menu.toArray(array);
        System.out.println(Arrays.toString(array));
        menu.removeIf(new LongProductName());
        System.out.println(menu);

    }
}
