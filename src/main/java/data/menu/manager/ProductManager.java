package data.menu.manager;

import data.menu.category.MenuCategory;

import java.util.List;

public interface ProductManager<T>{
    List<T> getProductList();
}
