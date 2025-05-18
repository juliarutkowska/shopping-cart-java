package test.domain.promotion.impl;

import domain.model.Product;
import domain.promotion.impl.Coupon30Percent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Coupon30PercentTest {
    @Test
    public void testCouponAppliedToCorrectProduct() {
        Product[] cart = {
                new Product("P1", "Shirt", 100),
                new Product("P2", "Hat", 50)
        };
        new Coupon30Percent("P2").apply(cart);
        assertEquals(35, cart[1].getDiscountPrice(), 0.01);
    }
}