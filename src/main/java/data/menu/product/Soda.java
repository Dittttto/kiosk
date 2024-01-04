package data.menu.product;

import data.menu.category.MenuCategory;

import java.math.BigDecimal;
import java.util.List;

public enum Soda {
    GRAPEFRUIT_ADE("자몽에이드", BigDecimal.valueOf(5000), "상큼한 자몽 에이드"),
    COCA_COLA("코카콜라", BigDecimal.valueOf(3000), "");

    private final String name;
    private final BigDecimal price;
    private final String description;

    Soda(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public List<Soda> getValues() {
        return List.of(Soda.values());
    }
}
