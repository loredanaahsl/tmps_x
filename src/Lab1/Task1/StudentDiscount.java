package Lab2.Task4.coffeeshop;

public class StudentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.85;
    }

    @Override
    public String getDiscountName() {
        return "Student Discount (15% off)";
    }
}
