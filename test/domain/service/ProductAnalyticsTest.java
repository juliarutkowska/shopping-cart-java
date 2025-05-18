package test.domain.service;

import domain.model.Product;
import domain.service.ProductAnalytics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductAnalyticsTest {
    @Test
    public void testFindCheapest() {
        Product[] products = {
                new Product("P1", "Item1", 100),
                new Product("P2", "Item2", 50),
                new Product("P3", "Item3", 70)
        };
        Product cheapest = ProductAnalytics.findCheapest(products);
        assertEquals("P2", cheapest.getCode());
    }

    @Test
    public void testTotalPrice() {
        Product[] products = {
                new Product("P1", "Item1", 100),
                new Product("P2", "Item2", 50)
        };
        products[0].applyDiscount(10); // 90
        products[1].applyDiscount(0);  // 50
        assertEquals(140, ProductAnalytics.totalPrice(products), 0.01);
    }
}
