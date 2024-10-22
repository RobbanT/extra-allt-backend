package com.backend.extraallt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.extraallt.services.ProductService;
import com.backend.extraallt.controllers.ProductController;

@SpringBootTest
public class ProductControllerTests {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductController productController = new ProductController(productService);

    @Test
    public void getCategory() {
        assertTrue(productController.getProductCategory("FOOD").size() > 0);
        assertTrue(productController.getProductCategory("WEAPONS").size() == 0);
    }

    @Test
    public void getProduct() {
        assertTrue(productController.getProduct("Samsung S95D") != null);
        assertTrue(productController.getProduct("Smör Normalsaltat") != null);
    }
}