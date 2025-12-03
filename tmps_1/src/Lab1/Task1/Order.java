package Lab2.Task4.coffeeshop;

import Lab2.Task1.Coffee;

public class Order {
    private final Coffee coffee;
    private final DiscountStrategy discount;

    public Order(Coffee coffee, DiscountStrategy discount) {
        this.coffee = coffee;
        this.discount = discount;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }
}
