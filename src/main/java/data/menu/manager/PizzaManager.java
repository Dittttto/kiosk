package data.menu.manager;

import data.menu.product.Pizza;

import java.util.List;

public class PizzaManager implements ProductManager<Pizza> {
    @Override
    public List<Pizza> getProductList() {
        return List.of(Pizza.values());
    }
}
