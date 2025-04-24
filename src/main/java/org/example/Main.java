package org.example;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

public class Main {

    public static void main(String... args) throws IOException, ParseException {
        LocalDate localDate = LocalDate.of(2024, Month.APRIL, 1);
        LocalTime localTime = LocalTime.of(11, 5);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
//        System.out.println("1 : " + localTime);
//        System.out.println("2 : " + localDate);
//        System.out.println("3 : " + localDateTime);
//        System.out.println("4 : " + localDateTime.toLocalDate());
//        System.out.println("5 : " + localDateTime.toLocalTime());
//        System.out.println("6 : " + localDate.atTime(localTime));
//        Date date = new Date();
//        System.out.println(date);
//        System.out.println(date.getTime());
//        date.setTime(55);
//        System.out.println(date);
//        System.out.println(date.getTime());
//        System.out.println(localTime.getHour());
//        System.out.println(localTime.getMinute());
//        System.out.println(localTime.getNano());
//        System.out.println(localTime.getSecond());
//        System.out.println(localDate.getDayOfMonth());
//        System.out.println(localDate.getDayOfYear());
//        System.out.println(localDate.getDayOfWeek());
//        System.out.println(localDate.getMonth());
//        System.out.println(localDate.getYear());
//        localDateTime.withHour(12).withMinute(30).plusHours(1).minusMinutes(15).withDayOfMonth(15);
//        System.out.println(localDateTime.withYear(2025).withHour(23).withMinute(2).plusHours(20).minusMinutes(65).withDayOfMonth(5).withDayOfYear(388));
//
//        System.out.println("0123456789");
//        System.out.print("""
//      t
//         jhkh
//        """);
        //        System.out.println(localDateTime);
        //        var timestamp = Instant.now();
        //        System.out.println(timestamp);
        //        System.out.println(timestamp.getNano());
//        var today = LocalDate.now();
//        var foolApril = LocalDate.of(2026, Month.APRIL, 1);
//        System.out.println(Period.between(today, foolApril).getDays());
//        System.out.println(Duration.ofHours(2).minusMinutes(15).getSeconds());
//        System.out.println(Instant.now());
//        System.out.println(Files.getLastModifiedTime(Paths.get("/home/aymenelidrissimoubtassim/Documents/testingV00")).toInstant());
//        System.out.println(LocalDate.ofInstant(Instant.ofEpochSecond(10000), ZoneId.systemDefault()));
//        System.out.println(LocalTime.ofInstant(Instant.ofEpochSecond(10000), ZoneId.systemDefault()));
//        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochSecond(10000), ZoneId.systemDefault()));
//        System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC));
//        ZoneId london = ZoneId.of("Europe/London");
//        ZoneId la = ZoneId.of("America/Los_Angeles");
//        System.out.println(london);
//        System.out.println(la);
//        LocalDateTime someTime = LocalDateTime.of(2019, Month.APRIL,5,12,14);
//        ZonedDateTime zonedLondon = ZonedDateTime.of(someTime, london);
//        ZonedDateTime zonedLa = ZonedDateTime.now().withZoneSameInstant(la);
//        System.out.println(someTime);
//        System.out.println(zonedLondon);
//        System.out.println(zonedLondon.withZoneSameInstant(la));
//        System.out.println(Locale.US);
//        System.out.println(new Locale("en", "us", "tex"));
//        System.out.println(new Locale.Builder().setLanguage("en").setRegion("re").build());
//        System.out.println(Locale.forLanguageTag("th-TH-u-ca-buddish-nu-thai"));
//        System.out.println(Locale.getDefault());
//        Locale l1 = new Locale("th", "TH");
//        Locale l2 = new Locale("th", "TH", "TH");
//        System.out.println(NumberFormat.getCurrencyInstance(l1).format(123.45));
//        System.out.println(NumberFormat.getCurrencyInstance(l2).format(123.45));
//        Locale.setDefault(Locale.Category.FORMAT, Locale.US);//why doesnt it work
//        Locale.setDefault(Locale.US);
//        System.out.println(Locale.getDefault());
//        Locale s1 = Locale.US;
//        Locale s2 = Locale.ITALIAN;
//        System.out.println(NumberFormat.getCurrencyInstance(s1).format(BigDecimal.valueOf(15.555)));
//        System.out.println(NumberFormat.getCurrencyInstance(s2).format(BigDecimal.valueOf(15.555)));
//        System.out.println(NumberFormat.getPercentInstance(s2).parse("15.555%"));
//        BigDecimal b = BigDecimal.valueOf((Double) NumberFormat.getCurrencyInstance(s1).parse("$15.56"));
//        System.out.println(b);
//        System.out.println(NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG).format(1000000));
//        System.out.println(NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT).format(1000000));
//        System.out.println(NumberFormat.getCompactNumberInstance(Locale.TAIWAN, NumberFormat.Style.SHORT).format(1000000));
//        System.out.println(NumberFormat.getCompactNumberInstance(Locale.TAIWAN, NumberFormat.Style.LONG).format(1000000));
//        record Hello(String name){ }
//        Hello h = new Hello("test");
//        System.out.println(h.name);//why
//         record Item(int id, String name, double price) implements Comparable<Item> {
//            public int compareTo(Item other) {
//                return Double.compare(this.price, other.price);
//            }
//        }
//        System.out.println(Test.values());
//        Test test = Test.valueOf("ACTIVE");
//        System.out.println(test);
//        System.out.println(Test.INACTIVE.ordinal());
//        Season.WINTER.printSeason();
//        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("EEEE dd MM yyyy", l1)));
//        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("EEEE dd MM yyyy", Locale.FRANCE)));
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).localizedBy(Locale.FRANCE)));
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).localizedBy(Locale.FRANCE)));
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).localizedBy(Locale.FRANCE)));
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(Locale.FRANCE)));
//        System.out.println(MessageFormat.format(ResourceBundle.getBundle("hello").getString("test"), "one", "two"));
//        Object[] obj = {"one", "two"};
//        System.out.println(new MessageFormat(ResourceBundle.getBundle("hello").getString("test"), Locale.ENGLISH).format(obj));
//        LocalDateTime ldt = LocalDateTime.parse("Tuesday 31 Mar 2020", DateTimeFormatter.ofPattern("EEEE dd MMM yyyy", Locale.ENGLISH));//why
//        System.out.println(ldt);//why
//        double[] quantities = {0,1,2};
//        String[] patterns = {"no product","a product","{0} product"};
//        ChoiceFormat choiceFormat = new ChoiceFormat(quantities, patterns);
//        MessageFormat formatter = new MessageFormat("Ordered {0, choice}");
//        formatter.setFormat(0, choiceFormat);
//        Object[] values = {1};
//        System.out.println(formatter.format(values));
//        MessageFormat format = new MessageFormat("{0}, {1} akbar");
//        Object[] objects = format.parse("test, allah akbar");
//        System.out.println(Arrays.toString(objects));
//        Locale locale = new Locale("en", "US");
//        ResourceBundle bundle = ResourceBundle.getBundle("hello", locale);
//        String pattern = bundle.getString("test");
//        Object[] values = {"name", BigDecimal.valueOf(2.99), Integer.valueOf(4), LocalDate.of(2019, Month.APRIL, 1)};
//        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
//        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy", locale);
//        Format[] formats = {null, currencyFormat, numberFormat, dateFormat.toFormat()};
//        MessageFormat messageFormat = new MessageFormat(pattern, locale);
//        messageFormat.setFormats(formats);
//        StringBuffer result = new StringBuffer();
//        messageFormat.format(values, result, new FieldPosition(MessageFormat.Field.ARGUMENT));
//        System.out.println(result);
//        StringBuilder sb1 = new StringBuilder("Java");
//        StringBuilder sb2 = new StringBuilder("Python");
//        sb1 = sb2;
//        System.out.println(sb1);
//        System.out.println(sb2);

//        outerLoop:
//        // label for the outer loop
//        for (int i = 1; i <= 3; i++) {
//            System.out.println("Outer loop i = " + i);
//
//            for (int j = 1; j <= 3; j++) {
//                if (j == 2) {
//                    System.out.println("  Skipping j = 2 using continue");
//                    continue; // skips current inner loop iteration
//                }
//
//                if (i == 2 && j == 3) {
//                    System.out.println("  Breaking out of outer loop completely");
//                    break outerLoop; // exits both loops
//                }
//
//                System.out.println("  Inner loop j = " + j);
//            }
//        }
//        int i = 0;
//        while(i < 5){
//            i++;
//            if(i == 2)
//                continue;
//            int j = 2;
//        }

//        String[] names = {"Mary", "Jane", "Ann", "Tom"};
//        int i = 0;
//        String name = null;
//        while (names.length > i) {
//            ++i;
//            if (names[i].length() == 3)
//                if (names[i].indexOf("a") == -1) {
//                    break;
//                }
//            name = names[i];
//            continue;
//        }
//        System.out.println(name);


        String[] names = {"Mary", "Jane", "Elizabeth", "Jo"};
        Arrays.sort(names, new Compare());
        for (String name : names) {
            System.out.println(name);
        }
    }

}

//    enum Test {
//        ACTIVE, INACTIVE, DELETED;
//
//        public void printStatus() {
//            System.out.println("Current status: " + this);
//        }
//    }
//    enum Season {
//        WINTER, SPRING, SUMMER, FALL;
//
//        public void printSeason() {
//            System.out.println("The season is " + this.name());
//        }
//    }
//}
