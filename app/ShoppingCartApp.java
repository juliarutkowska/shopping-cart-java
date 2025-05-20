package app;

import domain.model.Cart;
import domain.model.Product;
import domain.promotion.PromotionEngine;
import domain.promotion.impl.*;

public class ShoppingCartApp {
    public void run() {
        // Tworzymy koszyk
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Laptop", 2500));
        cart.addProduct(new Product("P2", "Mouse", 100));
        cart.addProduct(new Product("P3", "Mug", 50));
        cart.addProduct(new Product("P4", "Keyboard", 200));

        // Tworzymy silnik promocji
        PromotionEngine engine = new PromotionEngine();
        engine.addPromotion(new DiscountOver300());
        engine.addPromotion(new FreeThirdCheapest());
        engine.addPromotion(new FreeMugOver200());
        engine.addPromotion(new Coupon30Percent("P2")); // kupon na Mouse

        // Zastosuj promocje
        cart.applyPromotions(engine);

        // Wyświetl produkty
        System.out.println("Produkty po zastosowaniu promocji:");
        for (Product p : cart.getProducts()) {
            System.out.printf("%s - %.2f zł\n", p.getName(), p.getDiscountPrice());
        }
    }
}

