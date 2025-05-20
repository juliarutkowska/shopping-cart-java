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
        cart.addProduct(new Product("P2", "Mysz", 100));
        cart.addProduct(new Product("P3", "Kubek", 50));
        cart.addProduct(new Product("P4", "Klawiatura", 200));

        // Tworzymy silnik promocji
        PromotionEngine engine = new PromotionEngine();
        engine.addPromotion(new DiscountOver300());
        engine.addPromotion(new FreeThirdCheapest());
        engine.addPromotion(new FreeMugOver200());
        engine.addPromotion(new Coupon30Percent("P2")); // kupon na Mouse

        // Zastosuj promocje
        cart.applyPromotions(engine);

        // Wyświetl produkty
        System.out.println("\nProdukty końcowe mają poprawne ceny po zniżkach (discountPrice):\n");

        for (Product p : cart.getProducts()) {
            double regular = p.getPrice();
            double discounted = p.getDiscountPrice();
            String reason = "";

            if (discounted == 0.0) {
                if (p.getName().toLowerCase().contains("mug") || p.getName().toLowerCase().contains("kubek")) {
                    reason = "(kubek gratis)";
                } else {
                    reason = "(najtańszy z trzech za darmo)";
                }
            } else if (discounted < regular) {
                double percent = 100 - ((discounted / regular) * 100);
                if (Math.abs(percent - 5.0) < 0.5) {
                    reason = "(5% rabatu)";
                } else if (Math.abs(percent - 30.0) < 1.0) {
                    reason = "(30% kupon)";
                } else {
                    reason = String.format("(%.0f%% rabatu)", percent);
                }
            }

            System.out.printf("%s: %.2f zł → %.2f zł %s\n", p.getName(), regular, discounted, reason);
        }

    }
}

