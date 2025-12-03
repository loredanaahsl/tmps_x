package Lab2.Task1;

public abstract class Coffee {
    private final Intensity intensity;

    protected Coffee(Intensity intensity) {
        this.intensity = intensity;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public abstract String getName();

    /**
     * Returns base price for this coffee type.
     * Concrete subclasses can override if needed.
     */
    public double getBasePrice() {
        return 0.0;
    }

    @Override
    public String toString() {
        return getName() + " (" + intensity + ")";
    }
}
