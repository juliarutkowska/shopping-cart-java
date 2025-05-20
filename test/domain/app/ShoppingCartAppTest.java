package test.domain.app;

import app.ShoppingCartApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartAppTest {

    @Test
    void testAppRunsWithoutCrashing() {
        assertDoesNotThrow(() -> new ShoppingCartApp().run());
    }
}

