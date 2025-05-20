package domain.promotion.impl;

import domain.model.Product;
import domain.promotion.Promotion;
import domain.service.ProductAnalytics;

public class FreeMugOver200 implements Promotion {

    @Override
    public void apply(Product[] cart) {
        double total = ProductAnalytics.totalPrice(cart);
        if (total > 200) {
            for (Product p : cart) {
                if (p.getName().toLowerCase().contains("mug") || p.getName().toLowerCase().contains("kubek")) {
                    p.applyDiscount(p.getPrice()); // za darmo
                    return;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Darmowy kubek przy zakupach powyżej 200 zł";
    }
}



//import domain.model.Product;
//import domain.promotion.Promotion;
//
//import java.util.Arrays;
//
//public class FreeMugOver200 implements Promotion {
//    @Override
//    public void apply(Product[] cart) {
//        double total = Arrays.stream(cart).mapToDouble(Product::getPrice).sum();
//        if (total > 200) {
//            Product mug = new Product("MUG001", "JavaMarkt Mug", 0.0);
//            mug.applyDiscount(0.0);
//            Product[] newCart = Arrays.copyOf(cart, cart.length + 1);
//            newCart[cart.length] = mug;
//            System.arraycopy(newCart, 0, cart, 0, newCart.length);
//        }
//    }
//
//    @Override
//    public String getName() {
//        return "Free mug over 200 zł";
//    }
//}
