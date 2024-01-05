package domain.order;

import java.math.BigDecimal;
import java.util.List;

public class OrderList {
    private final List<Order> orders;
    private final BigDecimal totalPrice;

    public OrderList(List<Order> orders) {
        this.orders = orders;
        this.totalPrice = calcTotalPrice(orders);
    }

    private BigDecimal calcTotalPrice(List<Order> orders) {
        return orders.stream().map(Order::getPrice)
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "orders=" + orders +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
