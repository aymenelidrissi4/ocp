package nested.classes;

public class OuterMemberInner {
    // Outer class members
    private int privateVar = 10;
    public int publicVar = 20;
    static int staticVar = 30;

    // Member inner class (non-static)
    class Inner {
        // Only allowed static member: static final constant
        static int CONSTANT = 100;
        static int CONSTANT2 = 100;

        int innerVar = 200;

        void display() {
            System.out.println("Accessing outer privateVar: " + privateVar);   // ✅
            System.out.println("Accessing outer publicVar: " + publicVar);     // ✅
            System.out.println("Accessing outer staticVar: " + staticVar);     // ✅
            System.out.println("Inner class constant: " + CONSTANT);           // ✅
            System.out.println("Inner class constant 2: " + CONSTANT2);           // ✅
            System.out.println("Outer.this.privateVar = " + OuterMemberInner.this.privateVar); // ✅
        }
    }

    void outerMethod() {
        Inner inner = new Inner();
        inner.display();
    }

    public static void main(String[] args) {
        // Creating outer class instance
        OuterMemberInner outer = new OuterMemberInner();

        // Creating inner class instance from outer instance
        OuterMemberInner.Inner inner = outer.new Inner();

        // Call inner method
        inner.display();

        // Access constant from inner class
        System.out.println("Access constant: " + OuterMemberInner.Inner.CONSTANT);

        // Call from outer method
        outer.outerMethod();
    }
}


//public class Outer {
//    class Inner {
//        private Inner() {
//            System.out.println("Private Inner Constructor");
//        }
//
//        void show() {
//            System.out.println("Inner show()");
//        }
//    }
//
//    void createInner() {
//        // ✅ Allowed: inside outer class
//        Inner inner = new Inner();
//        inner.show();
//    }
//
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//
//        // ❌ Error: constructor Inner() is not visible
//        // Outer.Inner inner = outer.new Inner(); // Compile-time error
//
//        // ✅ This works because it's inside Outer
//        outer.createInner();
//    }
//}

