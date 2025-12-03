package Lab2.Task4.coffeeshop;

public class SeniorDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }

    @Override
    public String getDiscountName() {
        return "Senior Discount (10% off)";
    }
}
