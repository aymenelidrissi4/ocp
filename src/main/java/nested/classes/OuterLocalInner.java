package nested.classes;

public class OuterLocalInner {
    private int outerValue = 100;

    void outerMethod() {
        final int finalVar = 10;            // final variable
        int effectivelyFinalVar = 20;       // not changed, so effectively final

        // effectivelyFinalVar = 30; // ❌ Uncommenting this would cause a compile error

        // Local Inner Class
        class LocalInner {
            void display() {
                // Access outer class member
                System.out.println("Outer value: " + outerValue);

                // Access local variables from enclosing method
                System.out.println("Final variable: " + finalVar);
                System.out.println("Effectively final variable: " + effectivelyFinalVar);
            }
        }

        // Create and use local inner class
        LocalInner inner = new LocalInner();
        inner.display();
    }

    public static void main(String[] args) {
        OuterLocalInner outer = new OuterLocalInner();
        outer.outerMethod();
    }
    }
