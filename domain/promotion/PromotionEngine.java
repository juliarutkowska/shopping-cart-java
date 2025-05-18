package domain.promotion;

import domain.model.Product;

import java.util.ArrayList;
import java.util.List;

public class PromotionEngine {
    private List<Promotion> promotions = new ArrayList<>();

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public void removePromotion(Promotion promotion) {
        promotions.remove(promotion);
    }

    public void applyPromotions(Product[] cart) {
        for (Promotion promo : promotions) {
            promo.apply(cart);
        }
    }
}

