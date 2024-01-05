package data.product;

import java.math.BigDecimal;

public enum SauceSizeOption implements Option {
    HONEY("꿀", BigDecimal.valueOf(500)),
    NONE("없음", BigDecimal.ZERO);

    private final String name;
    private final BigDecimal addPrice;

    SauceSizeOption(String name, BigDecimal addPrice) {
        this.name = name;
        this.addPrice = addPrice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getAddPrice() {
        return addPrice;
    }
}