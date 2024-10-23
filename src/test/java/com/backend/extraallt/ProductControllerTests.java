package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.backend.extraallt.controllers.ProductController;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.services.ProductService;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class ProductControllerTests {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductController productController = new ProductController(productService);

    @Test
    public void getCategory() {
        // Kollar om en viss produktkategori existerar.
        assertTrue(productController.getProductCategory("FOOD").size() > 0);
        assertTrue(productController.getProductCategory("WEAPONS").size() == 0);
    }

    @Test
    public void getProduct() {
        // Kollar om en viss produkt existerar.
        assertTrue(productController.getProduct("Samsung S95D") != null);
        assertTrue(productController.getProduct("TEST") == null);
    }
}