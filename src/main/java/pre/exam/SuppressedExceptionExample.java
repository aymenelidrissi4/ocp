package pre.exam;

class Resource implements AutoCloseable {
    private boolean ok;
    
    public void dorhings(boolean ok) {
        this.ok = ok;
        if (!ok) throw new NotOkException("not ok");
        System.out.println("ok");
    }
    
    public void close() throws Exception {
        if (!ok) throw new Exception("error");
        System.out.println("closed");
    }
}
class NotOkException extends RuntimeException {
    public NotOkException(String message) {
        super(message);
    }
}

public class SuppressedExceptionExample {
    public static void main(String[] args) {
        try (Resource r = new Resource()) {
            r.dorhings(true);
            r.dorhings(false);
            r.dorhings(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed()[0].getMessage());
        }
    }
}