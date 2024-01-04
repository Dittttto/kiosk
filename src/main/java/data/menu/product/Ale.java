package data.menu.product;

import data.menu.category.MenuCategory;

import java.math.BigDecimal;
import java.util.List;

public enum Ale {
    STRAWBERRY_CHOCOLATE_STOUT("미니셀딸기맛", BigDecimal.valueOf(7900), "초콜릿과 딸기의 진한 여운이 입안에 오랜 감도는 프리미엄 스타우트"),
    STOUT("스타우트", BigDecimal.valueOf(6900), "초콜릿과 커피, 로스팅한 보리의 맛과 향을 제대로 담은 진한 흑맥주"),
    IPA("아이피에이", BigDecimal.valueOf(5900), "홉의 향긋함과 진하고 강한 바디감을 가진 수제맥주의 대명사"),
    PALE_ALE("페일 에일", BigDecimal.valueOf(5900), "향긋한 과일향과 쌉싸름한맛이 조화로운 에일의 교과서");

    private final String name;
    private final BigDecimal price;
    private final String description;

    Ale(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public List<Ale> getValues() {
        return List.of(Ale.values());
    }
}
