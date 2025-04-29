package stream;

import java.math.*;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.*;

public class PrimitiveInterfacesDemo {
    public static void main(String[] args) {
        // === Primitive Stream Pipeline ===
        int result = DoubleStream.of(1.234, 1.0, 3.987, 0.321, 4.0)
            .filter(n -> n != (int)n)                // DoublePredicate
            .boxed()
            .map(BigDecimal::valueOf)                // Function<Double, BigDecimal>
            .map(bd -> bd.round(new MathContext(0, RoundingMode.HALF_UP))) // UnaryOperator
            .mapToInt(BigDecimal::intValue)          // ToIntFunction
            .sum();                                  // Terminal
        
        System.out.println("Sum of rounded fractions: " + result); // 5 (1+4+0)

        // === Other Primitive Interface Examples ===
        IntSupplier randomInt = () -> (int)(Math.random() * 100);
        IntPredicate isEven = n -> n % 2 == 0;
        IntUnaryOperator square = n -> n * n;
        
        int sum = IntStream.generate(randomInt)
            .limit(5)
            .filter(isEven)                // IntPredicate
            .map(square)                   // IntUnaryOperator
            .sum();
        
        System.out.println("Sum of squared evens: " + sum);
    }
}