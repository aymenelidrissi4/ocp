package pre.exam;

public class Computer {
    int x = 12;
    static int y;
    public static void main(String[] args) {
        Computer c = new Computer();
        y = c.x;          // Step 1: y = 12 (static y now holds 12)
        y = c.compute(c.x); // Step 2: Calls compute(12), returns 12/6 = 2
        System.out.println(y); // Prints 2
    }
    int compute(int z) {
        z = 6;            // Overrides parameter z (but doesn't affect c.x)
        return y / z;     // Uses static y (12) / 6 = 2
    }
}

//public class Computer {
//    int x = 12;
//    static int y;
//    public static void main(String[] args) {
//        y = compute(x);   // ERROR: Non-static 'x' cannot be used in static context
//        System.out.println(y);
//    }
//    int compute(int z) {
//        z = 6;
//        return y / z;
//    }
//}


//public class Computer {
//    int x = 12;
//    static int y;
//    public static void main(String[] args) {
//        Computer c = new Computer();
//        y = c.compute(c.x); // ERROR: 'var z' re-declares parameter z
//        System.out.println(y);
//    }
//    int compute(int z) {
//        var z = 6;        // ERROR: Duplicate variable 'z'
//        return y / z;
//    }
//}