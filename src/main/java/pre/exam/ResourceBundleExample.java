package pre.exam;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {
    public static void main(String[] args) {
        Locale locale = new Locale("fr");
        Locale.setDefault(locale);
        locale = new Locale("en");
        ResourceBundle rb = ResourceBundle.getBundle("prompts", locale);
        String name = "Joe";
        String txt = MessageFormat.format(rb.getString("and"),
                MessageFormat.format(rb.getString("hello"), name),
                MessageFormat.format(rb.getString("goodbye"), name));
        System.out.println(txt);
    }
}
