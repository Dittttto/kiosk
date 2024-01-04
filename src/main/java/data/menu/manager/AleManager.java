package data.menu.manager;

import data.menu.product.Ale;

import java.util.List;

public class AleManager implements ProductManager<Ale> {
    @Override
    public List<Ale> getProductList() {
        return List.of(Ale.values());
    }
}
