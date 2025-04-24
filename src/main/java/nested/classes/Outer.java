package nested.classes;

public class Outer {
    static int outerStatic = 10;
    int outerNonStatic = 20;

    // Nested static class
    static class NestedStatic {
        void display() {
            // Can access static members of Outer
            System.out.println("Outer static: " + outerStatic);

//             Cannot access non-static members of Outer directly
//             System.out.println(outerNonStatic); // ❌ This will cause an error
        }
    }
}


//public class Outer {
//    static void staticMethod() {
//        System.out.println("Static method in Outer");
//    }
//
//    void nonStaticMethod() {
//        System.out.println("Non-static method in Outer");
//    }
//
//    static class NestedStatic {
//        void callMethods() {
//            // Can access static method directly
//            staticMethod(); // ✅
//
//            // Cannot access non-static method directly
//            // nonStaticMethod(); // ❌ Compile-time error
//
//            // But can do this:
//            Outer outer = new Outer();
//            outer.nonStaticMethod(); // ✅ Works via an instance
//        }
//    }
//}
