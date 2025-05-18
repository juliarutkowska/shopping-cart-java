package domain.promotion.impl;

import domain.model.Product;
import domain.promotion.Promotion;

import java.util.Arrays;

public class FreeMugOver200 implements Promotion {
    @Override
    public void apply(Product[] cart) {
        double total = Arrays.stream(cart).mapToDouble(Product::getPrice).sum();
        if (total > 200) {
            Product mug = new Product("MUG001", "JavaMarkt Mug", 0.0);
            mug.applyDiscount(0.0);
            Product[] newCart = Arrays.copyOf(cart, cart.length + 1);
            newCart[cart.length] = mug;
            System.arraycopy(newCart, 0, cart, 0, newCart.length);
        }
    }

    @Override
    public String getName() {
        return "Free mug over 200 zł";
    }
}
