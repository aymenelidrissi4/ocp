package pre.exam;

public class Message {
    static String txt = "A";
    static { txt += "B"; }          // Static initializer (runs when class loads)
    { txt += "C"; }                // Instance initializer (runs before each constructor)
    
    Message() { 
        txt += "D"; 
    }
    
    Message(String txt) {
        this();                     // Calls the no-arg constructor first
        Message.txt += txt;        // Appends the parameter to the static 'txt'
    }

    public static void main(String[] args) {
        new Message();              // Triggers initializers and no-arg constructor
        new Message("E");           // Triggers initializers, no-arg constructor, then appends "E"
        System.out.println(Message.txt); // Prints the final value of static 'txt'
    }
}