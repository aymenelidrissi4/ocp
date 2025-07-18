package real.prep;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "and", "WELCOME");
        String result = list.stream()
                .collect(Collectors.mapping(v -> Transformer.transform(v), Collectors.joining(" ")));
        System.out.println(result);
//q45
//        LocalDate d1 = LocalDate.of(2021, Month.JANUARY, 1);
//        LocalDate d2 = d1.plus(Period.ofDays(-10)).withMonth(1);
//        LocalDateTime ldt = d2.atTime(LocalTime.of(11, 11));
//        if (d1.isAfter(d2) ^ !d1.getMonth().equals(ldt.getMonth())) {
//            ldt = d2.atTime(LocalTime.of(12, 12));
//        }
//
//        System.out.println(ldt.format(DateTimeFormatter.ofPattern("HHMM")));
    }
}

 