package real.prep;

import java.util.function.UnaryOperator;

public enum Transformer {
    UPPER((String value) -> value.toUpperCase()),
    LOWER((String value) -> value.toLowerCase());
    private final UnaryOperator<String> operator;

    Transformer(UnaryOperator<String> operator) {
        this.operator = operator;
    }

    public static String transform(String value) {
        return switch (value) {
            case String v when v.toUpperCase().equals(value) -> LOWER.operator.apply(value);
            case String v when v.toLowerCase().equals(value) -> UPPER.operator.apply(value);
            default -> value;
        };
    }
}

//2
//package real.prep;
//
//import java.util.function.UnaryOperator;
//
//public enum Transformer {
//    UPPER((String value) -> value.toUpperCase()),
//    LOWER((String value) -> value.toLowerCase());
//    private final UnaryOperator<String> operator;
//
//    Transformer(UnaryOperator<String> operator) {
//        this.operator = operator;
//    }
//
//    public static String transform(String value) {
//        return Transformer.valueOf(
//                value.toUpperCase().equals(value) ? "U" : "L").operator.apply(value);
//    }
//
//    public String toString() {
//        return switch (this) {
//            case UPPER -> "U";
//            case LOWER -> "L";
//        };
//    }
//}