package test.domain.service;

import domain.model.Product;
import domain.service.ProductSorter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSorterTest {
    @Test
    public void testSortByDefault() {
        Product[] products = {
                new Product("P1", "A", 100),
                new Product("P2", "B", 200),
                new Product("P3", "C", 100)
        };
        ProductSorter sorter = new ProductSorter();
        Product[] sorted = sorter.sort(products);
        assertEquals("P2", sorted[0].getCode()); // najdroższy
        assertEquals("P1", sorted[1].getCode()); // A < C
    }
}
