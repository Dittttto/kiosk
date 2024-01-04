package data.menu.manager;

import data.menu.product.Larger;

import java.util.List;

public class LagerManager implements ProductManager<Larger> {
    @Override
    public List<Larger> getProductList() {
        return List.of(Larger.values());
    }
}
