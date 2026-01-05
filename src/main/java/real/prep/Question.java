package real.prep;

public class Question {

    public void answer(int a, int b) {
        System.out.println("A");
    }

    public void answer(int a, float b) {
        System.out.println("B");
    }

    public void answer(float a, float b) {
        System.out.println("C");
    }

    public void answer(double... a) {
        System.out.println("D");
    }

    public static void main(String[] args) {
        Question q = new Question();
        q.answer(10, 15.25);
        q.answer(10, 24);
        q.answer(10, 10.25);
    }
}
