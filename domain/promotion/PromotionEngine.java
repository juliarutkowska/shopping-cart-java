package domain.promotion;

// 1. NAJKORZYSTNIEJSZA KOLEJNOŚĆ PROMOCJI

import domain.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PromotionEngine {
    private final List<Promotion> promotions = new ArrayList<>();

    public void addPromotion(Promotion promo) {
        promotions.add(promo);
    }

    public void clearPromotions() {
        promotions.clear();
    }

    public void apply(Product[] cart) {
        List<Promotion> bestOrder = null;
        double lowestTotal = Double.MAX_VALUE;
        Product[] original = deepCopy(cart);

        for (List<Promotion> order : permutations(promotions)) {
            Product[] copy = deepCopy(original);
            for (Promotion p : order) p.apply(copy);
            double total = 0;
            for (Product product : copy) total += product.getDiscountPrice();
            if (total < lowestTotal) {
                lowestTotal = total;
                bestOrder = order;
            }
        }

        if (bestOrder != null) {
            for (Product p : cart) p.resetDiscount();
            for (Promotion p : bestOrder) p.apply(cart);
            System.out.println("Zastosowano najkorzystniejszą kolejność promocji:");
            for (Promotion p : bestOrder) System.out.println("- " + p.getName());
        }
    }

    private List<List<Promotion>> permutations(List<Promotion> list) {
        List<List<Promotion>> result = new ArrayList<>();
        permute(list, 0, result);
        return result;
    }

    private void permute(List<Promotion> list, int i, List<List<Promotion>> result) {
        if (i == list.size() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < list.size(); j++) {
            Collections.swap(list, i, j);
            permute(list, i + 1, result);
            Collections.swap(list, i, j);
        }
    }

    private Product[] deepCopy(Product[] cart) {
        Product[] copy = new Product[cart.length];
        for (int i = 0; i < cart.length; i++) {
            Product p = cart[i];
            Product pCopy = new Product(p.getCode(), p.getName(), p.getPrice());
            pCopy.applyDiscount(p.getPrice() - p.getDiscountPrice());
            copy[i] = pCopy;
        }
        return copy;
    }
}

//import domain.model.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PromotionEngine {
//    private List<Promotion> promotions = new ArrayList<>();
//
//    public void addPromotion(Promotion promotion) {
//        promotions.add(promotion);
//    }
//
//    public void removePromotion(Promotion promotion) {
//        promotions.remove(promotion);
//    }
//
//    public void applyPromotions(Product[] cart) {
//        for (Promotion promo : promotions) {
//            promo.apply(cart);
//        }
//    }
//}
//
