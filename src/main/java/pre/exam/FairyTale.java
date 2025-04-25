package pre.exam;

record Delivery(Box<String> box, String address) { }
record Box<T>(T present) { }

public class FairyTale {
    public static void main(String[] args) {
        Delivery d = new Delivery(new Box<String>("cake"), "grammy");
        
//        // Option 1
//        System.out.println("Option 1:");
//        if (d instanceof Delivery(Box box(var present), var address) && box.present != null) {
//            System.out.println(box.present + " for " + d.address);
//        }
//
//        // Option 2
//        System.out.println("\nOption 2:");
//        if (d instanceof Delivery(Box(var present), var address) || present == null) {
//            System.out.println(present + " for " + address);
//        }
//
//        // Option 3
//        System.out.println("\nOption 3:");
//        if (d instanceof Delivery(Box<>(var present), var address) && present != null) {
//            System.out.println(present + " for " + address);
//        }

        // Option 4
        System.out.println("\nOption 4:");
        if (d instanceof Delivery(Box(var present), var address) && present != null) {
            System.out.println(present + " for " + address);
        }
    }
}