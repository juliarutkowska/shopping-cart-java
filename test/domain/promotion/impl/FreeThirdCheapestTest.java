package test.domain.promotion.impl;

import domain.model.Product;
import domain.promotion.impl.FreeThirdCheapest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FreeThirdCheapestTest {
    @Test
    public void testFreeThirdCheapest() {
        Product[] cart = {
                new Product("P1", "Item1", 100),
                new Product("P2", "Item2", 50),
                new Product("P3", "Item3", 70),
                new Product("P4", "Item4", 40)
        };
        new FreeThirdCheapest().apply(cart);

        boolean found = false;
        for (Product p : cart) {
            if (p.getPrice() == 70 && p.getDiscountPrice() == 0.0) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
}