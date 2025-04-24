package collections;

import java.util.function.Predicate;

public class LongProductName implements Predicate<Product> {
    @Override
    public boolean test(Product product) {
        return product.getName().length() > 3;
    }
}
