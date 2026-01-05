package real.prep;

public class App {
    public String x = "01";

    public static void main(String[] args) {
        String x = "10";
        App t = new App();
        t.myMethod(x);
        System.out.println(x);
    }

    public void myMethod(String x){
        x += "1";
        System.out.println(x);
        System.out.println(this.x);
    }
}
//1010110
