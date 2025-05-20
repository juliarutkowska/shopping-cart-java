package domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {

    public List<Product> getProductList() {
        return products;
    }

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product[] getProducts() {
        return products.toArray(new Product[0]);
    }

    public void clear() {
        products.clear();
    }

    public void applyPromotions(domain.promotion.PromotionEngine engine) {
        engine.apply(getProducts());
    }
}

