package pre.exam;

public class Switch {
    public static String test(Number value) {
        return switch(value) {
            case Double num when num > 0 -> "Positive";
            case Double num when num < 0 -> "Negative";
            case Double num when num == 0 -> "Zero";
            default -> "Invalid";
        };
    }

    public static void main(String[] args) {
        try {
            Number num = Double.valueOf(1);
            System.out.println(test(num));
            num = null;
            System.out.println(test(num));
        } catch(Exception e) {
            System.out.println("Error");
        }
    }
}