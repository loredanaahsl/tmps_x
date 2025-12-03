package Lab2.Task1;

public class SyrupCappuccino extends Cappuccino {
    private final SyrupType syrup;
    private static final String coffee = "SyrupCappuccino";
    private static final double BASE_PRICE = 4.80;

    public SyrupCappuccino(Intensity intensityCoffee, int mlOfMilk, SyrupType syrup) {
        super(intensityCoffee, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    public static SyrupCappuccino makeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        return new SyrupCappuccino(intensity, mlOfMilk, syrup);
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
        return getName() + " (" + syrup + ") - " + getMlOfMilk() + "ml milk - " + getIntensity();
    }
}
