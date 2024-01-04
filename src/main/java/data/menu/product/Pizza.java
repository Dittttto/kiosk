package data.menu.product;

import data.menu.category.MenuCategory;

import java.math.BigDecimal;
import java.util.List;

public enum Pizza {
    CLASSIC_CHEESE_PIZZA("클래식치즈피자", BigDecimal.valueOf(21900), "모짜렐라치즈, 홈밀크티즈, 고다치즈, 체다치즈 4가지 다양한 치즈가 어우러진 고소한 피자"),
    PEPPERONI_PIZZA("페퍼로니피자", BigDecimal.valueOf(21900), "잘 구워진 페퍼로니와 치즈의 풍미가 어우러진 시그니처 피자"),
    POTATO_PIZZA("포페이토피자", BigDecimal.valueOf(21900), "포슬포슬 감자와 양파, 그리고 베이컨이 더해진 피자");

    private final String name;
    private final BigDecimal price;
    private final String description;

    Pizza(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public List<Pizza> getValues() {
        return List.of(Pizza.values());
    }
}
