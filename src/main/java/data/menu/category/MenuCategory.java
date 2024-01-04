package data.menu.category;

import java.util.List;

public enum MenuCategory {
    LARGER("7~15도에서 4~8주 동안 발효를 거친, 맑고 청량하고 깔끔한 맥주"),
    ALE("19~25도에서 2~3주 동안 발표를 거친, 상큼/달콤한 과일향이나고 목넘김이 부드러운 맥주"),
    PIZZA("아메리카 뉴욕 스타일의 브롱스 피자"),
    SALAD("상큼한 과일과 신선한 채소가 듬뿍 들어간 샐러드"),
    SODA("콜라와 사이다 등 논알콜 음료");

    private final String description;

    MenuCategory(String description) {
        this.description = description;
    }

    public List<MenuCategory> getValues() {
        return List.of(MenuCategory.values());
    }
}
