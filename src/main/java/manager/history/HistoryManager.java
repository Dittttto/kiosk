package manager.history;

import domain.order.Order;
import domain.order.OrderList;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryManager {
    private final Map<Number, OrderList> orderHistory = new HashMap<>();
    private final Map<String, BigDecimal> salesHistory = new HashMap<>();
    private BigDecimal totalSaleAmount = BigDecimal.ZERO;
    public long sequence = 0L;

    public long makeOrder(OrderList orders) {
        orderHistory.put(++sequence, orders);
        totalSaleAmount = totalSaleAmount.add(orders.getTotalPrice());
        accumulate(orders);
        return sequence;
    }

    public void accumulate(OrderList orderList) {
        List<Order> orders = orderList.getOrders();
        orders.forEach(order -> {
            String name = order.getName();
            BigDecimal price = order.getPrice();
            salesHistory.put(name, salesHistory.getOrDefault(name, BigDecimal.ZERO).add(price));
        });
    }

    public BigDecimal getTotalSaleAmount() {
        return salesHistory.values().stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Map<String, BigDecimal> getSalesHistory() {
        return salesHistory;
    }

    public void cancelOrder(long orderNumber) {
        orderHistory.remove(orderNumber);
    }

    public void cancelOrder() {
        orderHistory.clear();
    }
}
