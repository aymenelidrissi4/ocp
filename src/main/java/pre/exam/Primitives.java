package pre.exam;

import java.time.Duration;

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

        //qst : which expression is true for initialization
        //var slash3 = '\\\';
        //var 24H = Duration.ofHours(24);
        //var _ = "A_Z".indexOf("_");
        var slash2 = '\\';

        String[] txt = {"AB", "CD"};
        x:
        for (String value : txt) {
            var values = value.toCharArray();
            for (int i = values.length-1; i >= 0; i--) {
                if (i < 1) continue x;
                else if (values[i] == 'C') break;
                System.out.println(txt[i]);
            }
        }
//        String[] greeting = {""" Hello """, "world"};
//        float[][] smallchange = {1c, 5n, 10d, 21q};
//        var[][] matrix = {{1, 2},{1,2}};
//        boolean var = "xyz".charAt(0) == -1;
    }
}