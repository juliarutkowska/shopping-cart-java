package domain.promotion;

import domain.model.Product;

public interface Promotion {
    void apply(Product[] cart);
    String getName();
}
