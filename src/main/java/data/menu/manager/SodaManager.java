package data.menu.manager;

import data.menu.product.Soda;

import java.util.List;

public class SodaManager implements ProductManager<Soda> {
    @Override
    public List<Soda> getProductList() {
        return List.of(Soda.values());
    }
}
