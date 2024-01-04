package data.menu.manager;

import data.menu.category.MenuCategory;

import java.util.List;

public class MenuCategoryManager implements CategoryManager<MenuCategory>{

    @Override
    public List<MenuCategory> getCategoryList() {
        return List.of(MenuCategory.values());
    }
}
