package Lab2.Task4.coffeeshop;

public interface DiscountStrategy {
    double applyDiscount(double price);
    String getDiscountName();
}
