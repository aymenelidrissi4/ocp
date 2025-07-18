package pre.exam;

public class Contact {
    private final String prefix;
    private final String phone;

    public Contact(String phone) {
        this("4", phone);
    }

    public Contact(String prefix, String phone) {
        this.prefix = prefix;
        this.phone = phone;
    }

    public String getDetails() {
        return prefix + " " + phone;
    }
}