package data.menu.manager;

import data.menu.product.Salad;

import java.util.List;

public class SaladManager implements ProductManager<Salad>{
    @Override
    public List<Salad> getProductList() {
        return List.of(Salad.values());
    }
}
