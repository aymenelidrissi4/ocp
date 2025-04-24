package order.instance.initializers.constructors;

class Parent {
    // Static initializer block
    static {
        System.out.println("Parent static block");
    }

    // Instance initializer block
    {
        System.out.println("Parent instance block");
    }

    // Constructor
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    // Static initializer block
    static {
        System.out.println("Child static block");
    }

    // Instance initializer block
    {
        System.out.println("Child instance block");
    }

    // Constructor
    Child() {
        System.out.println("Child constructor");
    }
}

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Creating Child...");
        Child c = new Child();
    }
}

