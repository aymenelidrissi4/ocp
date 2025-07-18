package pre.exam;

public abstract sealed class Motor permits Electric, Combustion {
    private int power;

    public Motor() {

    }

    public Motor(int power) {
        this.power = power;
    }

    public abstract void doWork();

    public int getPower() {
        return power;
    }

    @Override
    public boolean equals(Object obj) {
//        return obj != null && obj.getClass().equals(this.getClass()) && ((Motor) obj).getPower() == this.getPower();
        if(obj instanceof Motor m){
            return m.getPower() == this.getPower();
        }
        return false;
    }
}