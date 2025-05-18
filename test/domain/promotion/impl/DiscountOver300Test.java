package test.domain.promotion.impl;

import domain.model.Product;
import domain.promotion.impl.DiscountOver300;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountOver300Test {
    @Test
    public void testAppliesWhenOver300() {
        Product[] cart = {
                new Product("P1", "TV", 250),
                new Product("P2", "Cable", 100)
        };
        new DiscountOver300().apply(cart);
        assertEquals(237.5, cart[0].getDiscountPrice(), 0.01);
        assertEquals(95, cart[1].getDiscountPrice(), 0.01);
    }

    @Test
    public void testNotAppliedWhenBelow300() {
        Product[] cart = {
                new Product("P1", "Mouse", 100),
                new Product("P2", "Keyboard", 150)
        };
        new DiscountOver300().apply(cart);
        assertEquals(100, cart[0].getDiscountPrice(), 0.01);
        assertEquals(150, cart[1].getDiscountPrice(), 0.01);
    }
}
