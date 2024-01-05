package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class StringFormatter {

    public static final int STANDARD_UNIT = 1000;

    private StringFormatter() {
    }

    public static String namePriceTemplate(String name,
                                               BigDecimal price) {

        return String.format("%-20s | W %s", name, priceToWon(price));
    }

    public static String nameDescPriceTemplate(String name,
                                               String desc,
                                               BigDecimal price) {

        return String.format("%-20s | W %s | %s", name, priceToWon(price), desc);
    }

    public static String nameDescPriceQuantityTemplate(String name,
                                                       String desc,
                                                       BigDecimal price,
                                                       int quantity) {

        return String.format("%-20s | W %s | %d개 | %s",
                name, priceToWon(price), quantity, desc);
    }

    public static String priceToWon(BigDecimal price) {
        return NumberFormat.getInstance(Locale.KOREA)
                .format(price.divide(BigDecimal.valueOf(STANDARD_UNIT)));
    }
}
