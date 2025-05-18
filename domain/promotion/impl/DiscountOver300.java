package domain.promotion.impl;

import domain.model.Product;
import domain.promotion.Promotion;

import java.util.Arrays;

public class DiscountOver300 implements Promotion {
    @Override
    public void apply(Product[] cart) {
        double total = Arrays.stream(cart).mapToDouble(Product::getPrice).sum();
        if (total > 300) {
            for (Product product : cart) {
                product.applyDiscount(product.getPrice() * 0.05);
            }
        }
    }

    @Override
    public String getName() {
        return "5% discount over 300 zł";
    }
}

