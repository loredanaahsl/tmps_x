package Lab2.Task1;

public class PumpkinSpiceLatte extends Cappuccino {
    private final int mgOfPumpkinSpice;
    private static final String name = "PumpkinSpiceLatte";
    private static final double BASE_PRICE = 5.00;

    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public static PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        return new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public String toString() {
        return getName() + " - " + getMlOfMilk() + "ml milk - " + mgOfPumpkinSpice + "mg spice - " + getIntensity();
    }
}
