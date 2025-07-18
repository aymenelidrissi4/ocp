package pre.exam;

public non-sealed class Combustion extends Motor {
    private int exhaust;

    public Combustion(int power) {
        super(power);
    }

    @Override
    public void doWork() {
        int availablePower = getPower();
        exhaust++;
    }
}