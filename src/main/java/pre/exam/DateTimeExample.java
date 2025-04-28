package pre.exam;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dM");
        var x = LocalDate.of(2001, 2, 5);
        var y = Period.ofMonths(3).plusDays(1);
        var z = x.plus(y);
        System.out.println(fmt.format(z));

    }
}
