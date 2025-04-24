package nested.classes;

class Animal {
    void sound() {
        System.out.println("Some generic sound");
    }
}

public class OuterAnonymousInner {
    public static void main(String[] args) {
        // Anonymous inner class extending Animal
        Animal dog = new Animal() {
            @Override
            void sound() {
                System.out.println("Woof woof!");
            }
        };

        dog.sound(); // Calls the overridden method
    }
}
