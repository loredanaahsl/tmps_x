package Lab2.Task1;

public class Americano extends Coffee {
    private final int mlOfWater;
    private static final String coffeeName = "Americano";
    private static final double BASE_PRICE = 3.00;

    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public static Americano makeAmericano(Intensity intensity, int mlOfWater) {
        return new Americano(intensity, mlOfWater);
    }

    @Override
    public String getName() {
        return coffeeName;
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public String toString() {
        return getName() + " - " + mlOfWater + "ml water - " + getIntensity();
    }
}
