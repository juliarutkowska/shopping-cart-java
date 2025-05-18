package domain.service;

import domain.model.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductAnalytics {

    public static Product findCheapest(Product[] products) {
        return Arrays.stream(products)
                .min(Comparator.comparingDouble(p -> p.getDiscountPrice()))
                .orElse(null);
    }

    public static Product findMostExpensive(Product[] products) {
        return Arrays.stream(products)
                .max(Comparator.comparingDouble(p -> p.getDiscountPrice()))
                .orElse(null);
    }

    public static Product[] findNMostExpensive(Product[] products, int n) {
        return Arrays.stream(products)
                .sorted(Comparator.comparingDouble(Product::getDiscountPrice).reversed())
                .limit(n)
                .toArray(Product[]::new);
    }

    public static double totalPrice(Product[] products) {
        return Arrays.stream(products)
                .mapToDouble(Product::getDiscountPrice)
                .sum();
    }
}

