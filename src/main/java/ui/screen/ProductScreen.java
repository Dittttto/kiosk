package ui.screen;

import domain.menu.Product;
import ui.common.CommonTemplate;
import util.InputReader;

import java.util.List;

import static util.StringFormatter.nameDescPriceTemplate;

public class ProductScreen {

    public Product active(List<Product> products, String menu) {
        CommonTemplate.showHeader();
        CommonTemplate.showMenuTitle(menu);
        showProducts(products);
        return InputReader.readProductInput(products::get);
    }

    private void showProducts(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            sb.append(i + 1)
                    .append(". ")
                    .append(nameDescPriceTemplate(
                            product.getName(),
                            product.getDescription(),
                            product.getPrice()
                    ))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
