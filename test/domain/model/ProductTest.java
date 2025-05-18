package test.domain.model;

import domain.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testApplyDiscount() {
        Product p = new Product("P1", "Test", 100);
        p.applyDiscount(20);
        assertEquals(80, p.getDiscountPrice(), 0.01);
    }

    @Test
    public void testResetDiscount() {
        Product p = new Product("P1", "Test", 100);
        p.applyDiscount(20);
        p.resetDiscount();
        assertEquals(100, p.getDiscountPrice(), 0.01);
    }

    @Test
    public void testCompareTo() {
        Product p1 = new Product("P1", "Alpha", 200);
        Product p2 = new Product("P2", "Beta", 100);
        assertTrue(p1.compareTo(p2) < 0); // bo 200 > 100 (malejąco)
    }
}
