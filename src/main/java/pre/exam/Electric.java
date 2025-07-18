package pre.exam;

public final class Electric extends Motor {
    public Electric() {
    }

    public Electric(int power) {
        super(power);
    }

    @Override
    public void doWork() {
        int availablePower = getPower();
    }
}
