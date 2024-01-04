package data.menu.product;

import data.menu.category.MenuCategory;

import java.math.BigDecimal;
import java.util.List;

public enum Salad {
    CAJUN_CHICKEN_SALAD("케이준치킨셀러드", BigDecimal.valueOf(16000), "신선한 야채가 듬뿍 들어간 치킨 샐러드"),
    RICOTTA_CHEESE_SALAD("리코타치즈셀러드", BigDecimal.valueOf(8900), "리코타치즈, 방울토마토, 아몬드, 발사믹소스를 곁들인 샐러드");

    private final String name;
    private final BigDecimal price;
    private final String description;

    Salad(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public List<Salad> getValues() {
        return List.of(Salad.values());
    }
}
