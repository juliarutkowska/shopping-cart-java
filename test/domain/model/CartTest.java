package test.domain.model;

import domain.model.Cart;
import domain.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    void testAddAndGetProducts() {
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Monitor", 800));
        Product[] products = cart.getProducts();
        assertEquals(1, products.length);
        assertEquals("Monitor", products[0].getName());
    }

    @Test
    void testClear() {
        Cart cart = new Cart();
        cart.addProduct(new Product("P1", "Monitor", 800));
        cart.clear();
        assertEquals(0, cart.getProducts().length);
    }
}
