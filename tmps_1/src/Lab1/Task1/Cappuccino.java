package Lab2.Task1;

public class Cappuccino extends Coffee {
    private final int mlOfMilk;
    private static final String coffee = "Cappuccino";
    private static final double BASE_PRICE = 4.50;

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public static Cappuccino makeCappuccino(Intensity intensity, int mlOfMilk) {
        return new Cappuccino(intensity, mlOfMilk);
    }

    @Override
    public String getName() {
        return coffee;
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public String toString() {
        return getName() + " - " + mlOfMilk + "ml milk - " + getIntensity();
    }
}
