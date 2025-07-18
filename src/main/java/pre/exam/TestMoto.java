package pre.exam;

public class TestMoto {
    public static void main(String[] args) {
        Motor m1 = new Electric(20);
        Motor m2 = new Combustion(20);
        Motor m3 = new Electric();

        System.out.println(m1.equals(m2) + " " +
                m2.equals(m3) + " " +
                m1.equals(m3));
    }
}
