package Lab2.Task4.coffeeshop;

public class LoyaltyDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.80;
    }

    @Override
    public String getDiscountName() {
        return "Loyalty Member (20% off)";
    }
}
