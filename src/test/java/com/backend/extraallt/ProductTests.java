package com.backend.extraallt;

import com.backend.extraallt.models.Product.Categories;
import static org.junit.jupiter.api.Assertions.*;
import com.backend.extraallt.models.Product;
import org.junit.jupiter.api.Test;

public class ProductTests {
    @Test
    public void setPriceTest() {
        // Kollar om maxvärdet för en long kan tilldelas som price.
        Product product = new Product(Categories.CLOTHES, "TEST", "TEST", "TEST", Long.MAX_VALUE);
        assertTrue(product.getPrice() == Long.MAX_VALUE);
        assertFalse(product.getPrice() > Long.MAX_VALUE);
    }
}
