package domain.promotion.impl;

import domain.model.Product;
import domain.promotion.Promotion;

public class Coupon30Percent implements Promotion {
    private String productCode;

    public Coupon30Percent(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public void apply(Product[] cart) {
        for (Product product : cart) {
            if (product.getCode().equals(productCode)) {
                product.applyDiscount(product.getPrice() * 0.3);
                return;
            }
        }
    }

    @Override
    public String getName() {
        return "30% coupon for product: " + productCode;
    }
}

