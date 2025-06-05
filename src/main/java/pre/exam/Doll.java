package pre.exam;

public class Doll {
    private String color;
    private Doll doll;
    
    public Doll(String color) {
        this.color = color;
    }
    
    public Doll(String color, Doll doll) {
        this(color);
        this.doll = doll;
    }
    
    public Doll open() {
        return this.doll;
    }
    
    public String toString() {
        return this.color;
    }
    
    public static void main(String[] args) {
        try {
            Doll d1 = new Doll("green");
            Doll d2 = new Doll("yellow", d1);
            Doll d3 = d2.open();
            d3 = null;
            System.out.println("The " + d2.open() + " doll is inside the " + d2 + " doll");
        } catch (Exception e) {
            System.out.println("Broken dolls");
        }
    }
}