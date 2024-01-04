package data.menu.product;

import java.math.BigDecimal;
import java.util.List;

public enum Larger {
    WORT_LARGER("첫즙라거", BigDecimal.valueOf(7900), "첫번째 맥아즙의 깊고 풍부한 맛과 향을 느낄 수 있는 라거"),
    LEMON_MARMALADE("레몬마멀레이드", BigDecimal.valueOf(6900), "상큼한 레몬향을 은은하게 느낄 수 있는 청량한 라거"),
    LARGER_ON_THE_BEACH("라거온더비치", BigDecimal.valueOf(5900), "열대과일의 맛이 느껴지는 쿨한 느낌의 라거"),
    DARK_LARGER("다크라거", BigDecimal.valueOf(4900), "구운보리의 고소함이 입암 가득 느꺄지는 라거 스타일의 흑맥주");

    private final String name;
    private final BigDecimal price;
    private final String description;

    Larger(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public List<Larger> getValues() {
        return List.of(Larger.values());
    }
}
