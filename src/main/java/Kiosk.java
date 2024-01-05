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
        ProductManager productManager = new ProductManager();
        MainScreen mainScreen = new MainScreen();
        ProductScreen productScreen = new ProductScreen();
        TotalSalesScreen totalSalesScreen = new TotalSalesScreen();
        AddCartToast addCartToast = new AddCartToast();
        CartManager cartManager = new CartManager();
        OrderConfirmScreen orderConfirmScreen = new OrderConfirmScreen();
        HistoryManager historyManager = new HistoryManager();
        OrderNumberToast orderNumberToast = new OrderNumberToast();
        OrderCancelToast orderCancelToast = new OrderCancelToast();
        OptionManager optionManager = new OptionManager();
        OptionToast optionToast = new OptionToast();
        ScreenCore core = new ScreenCore(
                productManager,
                mainScreen,
                productScreen,
                totalSalesScreen,
                addCartToast,
                cartManager,
                orderConfirmScreen,
                historyManager,
                orderNumberToast,
                orderCancelToast,
                optionManager,
                optionToast
        );
        core.activeMainScreen();
    }
    private void loadComponent() {
        // TODO initialize all class component
    }
}
