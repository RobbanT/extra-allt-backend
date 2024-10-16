package com.backend.extraallt.services;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;
import com.backend.extraallt.models.Product;
import java.util.*;

@Service
public class ProductService {
    private final MongoOperations mongoOperations;

    public ProductService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Product getProduct(String title) {
        return mongoOperations.findOne(new Query().addCriteria(Criteria.where("title").is(title)), Product.class);
    }

    public List<Product> getProducts() {
        return mongoOperations.findAll(Product.class);
    }

    public List<Product> getProductCategory(String category) {
        List<Product> products = getProducts();
        products.removeIf(product -> !product.getCategory().toString().equals(category));
        return products;
    }
}