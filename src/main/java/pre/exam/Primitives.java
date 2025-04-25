package pre.exam;

public class Primitives {
    public static void main(String[] args) {
        // Correct initialization
        boolean var = "xyz".charAt(0) == -1;  // Evaluates to false ('x' != -1)
        System.out.println("Correct boolean: " + var);

        // Incorrect initializations (commented out with reasons)

        // 1. Invalid float array initialization
//         float[][] smallchange = {1c,5n,10d,25d};  // Error: Invalid numeric literals

        // 2. Invalid var array declaration
        // var[][] matrix = {{1,2},{3,4}};  // Error: 'var' cannot be used for array declarations

        // 3. Invalid String array (lowercase 'string' and improper text block)
//         String[] greeting = {""" Hello """, "world"};  // Error: 'string' should be 'String'


        String txt1 = """  
                 \tHello  
                World  
                """;
        System.out.println(txt1.indexOf("o", 7));

        double a = 0.1, b = 0.2, c = 0.3;
        if ((c = Math.round(c += a++ + b)) > (a = b += c)) {
            System.out.println("X");
        } else if (a > b || b > c) {
            System.out.println("Y");
        } else {
            System.out.println("Z");
        }
    }
}