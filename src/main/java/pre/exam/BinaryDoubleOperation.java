package pre.exam;

public class BinaryDoubleOperation {
    public static void main(String[] args) {
        int a = 0b1;          // Binary literal for 1 (decimal)
        double b = 4.0;
        double c = Math.round(a / b * b) / b;
        System.out.println(c); // Output: 0.25
    }
}