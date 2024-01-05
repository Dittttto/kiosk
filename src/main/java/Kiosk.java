import manager.cart.CartManager;
import manager.history.HistoryManager;
import manager.product.OptionManager;
import manager.product.ProductManager;
import domain.screen.ScreenCore;
import ui.screen.MainScreen;
import ui.screen.ProductScreen;
import ui.screen.TotalSalesScreen;
import ui.toast.*;

public class Kiosk {
    public static void main(String[] args) {
        // Manager
        final ProductManager productManager = new ProductManager();
        final HistoryManager historyManager = new HistoryManager();
        final OptionManager optionManager = new OptionManager();
        final CartManager cartManager = new CartManager();

        // Screen
        final OrderConfirmScreen orderConfirmScreen = new OrderConfirmScreen();
        final TotalSalesScreen totalSalesScreen = new TotalSalesScreen();
        final ProductScreen productScreen = new ProductScreen();
        final MainScreen mainScreen = new MainScreen();

        // Toast
        final OrderNumberToast orderNumberToast = new OrderNumberToast();
        final OrderCancelToast orderCancelToast = new OrderCancelToast();
        final AddCartToast addCartToast = new AddCartToast();
        final OptionToast optionToast = new OptionToast();

        final ScreenCore core = new ScreenCore(
                productManager,
                historyManager,
                optionManager,
                cartManager,
                orderConfirmScreen,
                totalSalesScreen,
                productScreen,
                mainScreen,
                orderNumberToast,
                orderCancelToast,
                addCartToast,
                optionToast
        );

        core.activeMainScreen();
    }
}
