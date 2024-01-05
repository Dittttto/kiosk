package domain.order;

import java.math.BigDecimal;

public class Order {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final String option;
    private int quantity;

    public Order(String name, String description, BigDecimal price, String option) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.option = option;
        this.quantity = 1;
    }

    public Order(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.option = "-";
        this.quantity = 1;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOption() {
        return option;
    }

    public void increaseQuantity() {
        this.quantity += 1;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
