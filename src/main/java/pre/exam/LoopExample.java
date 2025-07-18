package pre.exam;

public class LoopExample {
    public static void main(String[] args) {
        String[] txt = {"AB", "CD"};
        
        x:
        for (String value : txt) {
            var values = value.toCharArray();
            for (int i = values.length - 1; i >= 0; i--) {
                if (i < 1)
                    continue x;
                else if (values[i] == 'C')
                    break;
                System.out.println(txt[i]);
            }
        }
    }
}