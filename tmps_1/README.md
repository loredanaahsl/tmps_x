
# 🥐☕ Local Bistro by Condrea Loredana

A simple **Java console application** demonstrating three **SOLID principles** — **SRP, OCP, DIP** — through a realistic **bakery and café ordering system** with an interactive menu.

---

## 🍽 Project Overview

This project simulates a modern bakery and café where customers can:

- Choose between **Drinks ☕**  categories  
- Select from multiple menu items, including **coffees, specialty drinks**  
- Apply various discounts (**Student, Morning, Loyalty, Senior**)  
- Receive a **formatted digital receipt**

The goal is to show how **SOLID principles** improve software design, readability, and scalability in a **practical context**.

---

## 🛠 Implemented SOLID Principles

### 1️⃣ Single Responsibility Principle (SRP)
Each class has **one responsibility**:

- **Coffee subclasses** (`Americano`, `Cappuccino`, `SyrupCappuccino`, `PumpkinSpiceLatte`) → store drink data  
- **Barista class** → handles customer interaction and order processing  
- **Discount classes** → calculate discounts  

```java
class Order {
    private String customerName;
    private String itemName;
    private double basePrice;
    public Order(String customerName, String itemName, double basePrice) {
        this.customerName = customerName;
        this.itemName = itemName;
        this.basePrice = basePrice;
    }
}
````

### 2️⃣ Open/Closed Principle (OCP)

The discount system is **open for extension but closed for modification**. You can add new discount types without changing existing code:

```java
interface DiscountStrategy {
    double applyDiscount(double price);
    String getDiscountName();
}
```

### 3️⃣ Dependency Inversion Principle (DIP)

**Barista** depends on the `DiscountStrategy` **interface** rather than concrete classes. This makes the system **flexible** and **testable**.

```java
class OrderProcessor {
    private DiscountStrategy discountStrategy;
    public OrderProcessor(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public void processOrder(Order order) {
        double finalPrice = discountStrategy.applyDiscount(order.getBasePrice());
    }
}
```

---

## 🍰 Main Flow

1. User enters their name
2. Chooses category: **Drinks ☕** 
3. Selects an item from the menu
4. Chooses a discount
5. Receives a **formatted receipt**

---

## 🗂 Key Components

* **Coffee Classes** – data containers for drinks
* **Food Classes** – data containers for pastries and desserts
* **DiscountStrategy Interface** – defines the contract for discounts
* **Concrete Discount Classes** – `NoDiscount`, `StudentDiscount`, `LoyaltyDiscount`, `SeniorDiscount`
* **Barista Class** – handles menu interaction and order processing
* **Main Class** – entry point for the console application



## 🎯 Key Takeaways

* **SRP** – Each class has a clear, single purpose
* **OCP** – Easily add new menu items or discounts without modifying existing code
* **DIP** – Flexible, testable system using interfaces instead of concrete implementations

This project demonstrates how applying **SOLID principles** in a bakery and café scenario leads to **clean, maintainable, and extensible code**.

