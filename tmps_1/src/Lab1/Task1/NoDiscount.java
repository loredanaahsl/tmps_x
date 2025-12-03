package Lab2.Task4.coffeeshop;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }

    @Override
    public String getDiscountName() {
        return "No Discount";
    }
}
