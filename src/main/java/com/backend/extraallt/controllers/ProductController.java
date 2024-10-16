package com.backend.extraallt.controllers;

import com.backend.extraallt.services.ProductService;
import org.springframework.web.bind.annotation.*;
import com.backend.extraallt.models.Product;
import java.util.*;

@CrossOrigin("*")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Hämtar en produkt.
    @GetMapping("product/{title}")
    public Product getProduct(@PathVariable String title) {
        return productService.getProduct(title);
    }

    // Hämtar alla produkter.
    @GetMapping("products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // Hämtar alla produkter i en viss kategori.
    @GetMapping("product/category/{category}")
    public List<Product> getProductCategory(@PathVariable String category) {
        return productService.getProductCategory(category);
    }

}
