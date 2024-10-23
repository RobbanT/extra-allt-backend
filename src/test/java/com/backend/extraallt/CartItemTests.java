package com.backend.extraallt;

import com.backend.extraallt.models.Product.Categories;
import static org.junit.jupiter.api.Assertions.*;
import com.backend.extraallt.models.CartItem;
import org.junit.jupiter.api.Test;

public class CartItemTests {
    @Test
    public void setQuantityTest() {
        // Kontrollerar om man kan ha ett negativt antal av en viss produkt i varukorgen.
        CartItem cartItem = new CartItem(Categories.CLOTHES, "TEST", "TEST", "TEST", 100L, -5L);
        assertTrue(cartItem.getQuantity() < 0);
        assertFalse(cartItem.getQuantity() >= 0);
    }
}
