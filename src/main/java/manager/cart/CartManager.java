package manager.cart;

import domain.order.Order;
import domain.order.OrderList;

public class CartManager {
    private final Cart cart = new Cart();

    public void addToCart(Order order) {
        cart.insert(order);
    }

    public OrderList getOrders() {
        return new OrderList(cart.getOrders());
    }

    public void clearCart() {
        cart.removeAll();
    }

    public boolean hasOrder() {
        return cart.hasOrder();
    }
}
