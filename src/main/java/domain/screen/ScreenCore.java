package domain.screen;

import data.product.Option;
import domain.menu.Product;
import domain.order.Order;
import domain.order.OrderList;
import manager.cart.CartManager;
import manager.history.HistoryManager;
import manager.product.OptionManager;
import manager.product.ProductManager;
import ui.screen.MainScreen;
import ui.screen.ProductScreen;
import ui.screen.TotalSalesScreen;
import ui.toast.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ScreenCore {
    private final ProductManager productManager;
    private final CartManager cartManager;
    private final HistoryManager historyManager;
    private final OptionManager optionManager;

    private final MainScreen mainScreen;
    private final ProductScreen productScreen;
    private final TotalSalesScreen totalSalesScreen;

    private final AddCartToast addCartToast;
    private final OrderConfirmScreen orderConfirmScreen;
    private final OrderNumberToast orderNumberToast;
    private final OrderCancelToast orderCancelToast;
    private final OptionToast optionToast;

    public ScreenCore(ProductManager manager,
                      MainScreen mainScreen,
                      ProductScreen productScreen,
                      TotalSalesScreen totalSalesScreen,
                      AddCartToast addCartToast,
                      CartManager cartManager,
                      OrderConfirmScreen orderConfirmScreen,
                      HistoryManager historyManager,
                      OrderNumberToast orderNumberToast,
                      OrderCancelToast orderCancelToast,
                      OptionManager optionManager,
                      OptionToast optionToast
                      ) {
        this.productManager = manager;
        this.mainScreen = mainScreen;
        this.productScreen = productScreen;
        this.totalSalesScreen = totalSalesScreen;
        this.addCartToast = addCartToast;
        this.cartManager = cartManager;
        this.orderConfirmScreen = orderConfirmScreen;
        this.historyManager = historyManager;
        this.orderNumberToast = orderNumberToast;
        this.orderCancelToast = orderCancelToast;
        this.optionManager = optionManager;
        this.optionToast = optionToast;
    }

    public void activeMainScreen() {
        InputCommand command = mainScreen.active();
        switch (command) {
            case SHUTDOWN -> shutdown();
            case TOTAL_SALES -> activeTotalSalesScreen();
            case ORDER -> activeOrderConfirmPopUp();
            case CANCEL -> activeOrderCancelPopUp();
            default -> activeProductScreen(command.name());
        }
    }

    private void activeTotalSalesScreen() {
        BigDecimal totalSaleAmount = historyManager.getTotalSaleAmount();
        Map<String, BigDecimal> salesHistory = historyManager.getSalesHistory();
        totalSalesScreen.active(salesHistory, totalSaleAmount);
        activeMainScreen();
    }

    private void shutdown() {
        cartManager.clearCart();
        System.out.println("Kiosk를 종료합니다. 감사합니다.");
    }

    private void activeOrderCancelPopUp() {
        if (checkOpenOrders()) {
            activeMainScreen();
            return;
        }

        boolean isCancel = orderCancelToast.active();

        if (isCancel) {
            cartManager.clearCart();
        }

        activeMainScreen();
    }

    private boolean checkOpenOrders() {
        if (!cartManager.hasOrder()) {
            System.out.println("장바구니가 비어있습니다.");
            return true;
        }

        return false;
    }

    private void activeProductScreen(String menu) {
        List<Product> products = productManager.getProductsByMenu(menu);
        Product product = productScreen.active(products, menu);
        Order order = new Order(product.getName(),
                product.getDescription(),
                product.getPrice());
        order = activeOptionToast(order, menu);
        activeAddCartPopUp(order, menu);
    }

    private Order activeOptionToast(Order order, String menu) {
        List<Option> options = optionManager.getOptions(menu);
        Option selectOption = optionToast.active(options, order);
        return new Order(
                order.getName(),
                order.getDescription(),
                order.getPrice().add(selectOption.getAddPrice()),
                selectOption.getName());
    }


    private void activeOrderNumberPopUp(long orderNumber) {
        orderNumberToast.active(orderNumber);
        setTimer();
    }

    private void setTimer() {
        long countTime = 3000L;
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                activeMainScreen();
                timer.cancel();

            }
        };

        timer.schedule(task, countTime);
    }

    private void activeOrderConfirmPopUp() {
        if (checkOpenOrders()) {
            activeMainScreen();
            return;
        }

        OrderList orders = cartManager.getOrders();
        boolean confirmOrder = orderConfirmScreen.active(orders);

        if (!confirmOrder) {
            activeMainScreen();
            return;
        }
        cartManager.clearCart();
        activeOrderNumberPopUp(historyManager.makeOrder(orders));
    }

    private void activeAddCartPopUp(Order order, String menu) {
        boolean isAdd = addCartToast.active(order);

        if (!isAdd) {
            activeProductScreen(menu);
            return;
        }

        cartManager.addToCart(order);
        activeMainScreen();
    }
}
