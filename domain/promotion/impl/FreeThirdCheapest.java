package domain.promotion.impl;

import domain.model.Product;
import domain.promotion.Promotion;

import java.util.Arrays;
import java.util.Comparator;

public class FreeThirdCheapest implements Promotion {
    @Override
    public void apply(Product[] cart) {
        if (cart.length < 3) return;

        Product[] sorted = Arrays.copyOf(cart, cart.length);
        Arrays.sort(sorted, Comparator.comparingDouble(Product::getPrice));

        Product thirdCheapest = sorted[2];
        thirdCheapest.applyDiscount(thirdCheapest.getPrice());
    }

    @Override
    public String getName() {
        return "Najtańszy z trzech za darmo";
    }
}

