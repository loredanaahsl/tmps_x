package Lab2.Task4.coffeeshop;

import Lab2.Task1.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barista {
    private String name;
    private List<Order> orders;

    public Barista(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void startCoffeeShop() {
        System.out.println("Hi!!!  Welcome to the coffee shop!\u2615");

        Scanner scanner = new Scanner(System.in);
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("\nTypes of coffee we serve:");
            System.out.println("1. Americano");
            System.out.println("2. Cappuccino");
            System.out.println("3. Syrup Cappuccino");
            System.out.println("4. Pumpkin Spice Latte");
            System.out.print("Enter the number of your choice: ");

            int coffeeChoice = readInt(scanner);
            Coffee drink;

            switch (coffeeChoice) {
                case 1:
                    drink = makeAmericano(scanner);
                    break;
                case 2:
                    drink = makeCappuccino(scanner);
                    break;
                case 3:
                    drink = makeSyrupCappuccino(scanner);
                    break;
                case 4:
                    drink = makePumpkinSpiceLatte(scanner);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }

            // Ask for discount for this order
            DiscountStrategy discount = chooseDiscount(scanner);

            // Create order and add
            Order order = new Order(drink, discount);
            orders.add(order);

            double finalPrice = discount.applyDiscount(drink.getBasePrice());
            System.out.printf("Your drink is ready: %s -> Final price: $%.2f (base $%.2f, discount: %s)%n",
                    drink.toString(), finalPrice, drink.getBasePrice(), discount.getDiscountName());

            System.out.print("Do you want to make another order? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            continueOrdering = response.equals("y") || response.equals("yes");
        }

        System.out.println("\nThank you for your orders ! Here is your order summary:");
        int index = 1;
        for (Order order : orders) {
            System.out.printf("%d. %s -> Base: $%.2f, Discount: %s, Final: $%.2f%n",
                    index++,
                    order.getCoffee().toString(),
                    order.getCoffee().getBasePrice(),
                    order.getDiscount().getDiscountName(),
                    order.getDiscount().applyDiscount(order.getCoffee().getBasePrice()));
        }
        System.out.println("Bye bye! Come again!! ☕");
    }

    private DiscountStrategy chooseDiscount(Scanner scanner) {
        System.out.println("\nSelect discount:");
        System.out.println("1. No Discount");
        System.out.println("2. Student Discount (15% off)");
        System.out.println("3. Loyalty Member (20% off)");
        System.out.println("4. Senior Discount (10% off)");
        System.out.print("Choice: ");
        int choice = readInt(scanner);

        return switch (choice) {
            case 2 -> new StudentDiscount();
            case 3 -> new LoyaltyDiscount();
            case 4 -> new SeniorDiscount();
            default -> new NoDiscount();
        };
    }

    private Coffee makeAmericano(Scanner scanner) {
        Intensity intensity = askIntensity(scanner);
        System.out.print("How many ml of water? ");
        int water = readInt(scanner);
        return Americano.makeAmericano(intensity, water);
    }

    private Coffee makeCappuccino(Scanner scanner) {
        Intensity intensity = askIntensity(scanner);
        System.out.print("How many ml of milk? ");
        int milk = readInt(scanner);
        return Cappuccino.makeCappuccino(intensity, milk);
    }

    private Coffee makeSyrupCappuccino(Scanner scanner) {
        Intensity intensity = askIntensity(scanner);
        System.out.print("How many ml of milk? ");
        int milk = readInt(scanner);
        SyrupType syrup = askSyrupType(scanner);
        return SyrupCappuccino.makeSyrupCappuccino(intensity, milk, syrup);
    }

    private Coffee makePumpkinSpiceLatte(Scanner scanner) {
        Intensity intensity = askIntensity(scanner);
        System.out.print("How many ml of milk? ");
        int milk = readInt(scanner);
        System.out.print("How many mg of pumpkin spice? ");
        int spice = readInt(scanner);
        return PumpkinSpiceLatte.makePumpkinSpiceLatte(intensity, milk, spice);
    }

    private int readInt(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.matches("\\d+")) {
                return Integer.parseInt(line);
            } else {
                System.out.print("Please enter a valid positive number: ");
            }
        }
    }

    private Intensity askIntensity(Scanner scanner) {
        while (true) {
            System.out.println("Choose intensity:\n1. Light\n2. Normal\n3. Strong");
            System.out.print("Choice: ");
            String line = scanner.nextLine().trim();
            if (line.matches("\\d+")) {
                int v = Integer.parseInt(line);
                return switch (v) {
                    case 1 -> Intensity.LIGHT;
                    case 2 -> Intensity.NORMAL;
                    case 3 -> Intensity.STRONG;
                    default -> { System.out.println("Please choose 1-3"); yield null; }
                };
            } else {
                System.out.println("Please enter a number (1-3)");
            }
        }
    }

    private SyrupType askSyrupType(Scanner scanner) {
        while (true) {
            System.out.println("Choose syrup type:\n1. Macadamia\n2. Vanilla\n3. Coconut\n4. Caramel\n5. Chocolate\n6. Popcorn");
            System.out.print("Choice: ");
            String line = scanner.nextLine().trim();
            if (line.matches("\\d+")) {
                int v = Integer.parseInt(line);
                return switch (v) {
                    case 1 -> SyrupType.MACADAMIA;
                    case 2 -> SyrupType.VANILLA;
                    case 3 -> SyrupType.COCONUT;
                    case 4 -> SyrupType.CARAMEL;
                    case 5 -> SyrupType.CHOCOLATE;
                    case 6 -> SyrupType.POPCORN;
                    default -> { System.out.println("Please choose 1-6"); yield null; }
                };
            } else {
                System.out.println("Please enter a number (1-6)");
            }
        }
    }
}
