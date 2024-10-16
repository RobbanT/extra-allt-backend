package com.backend.extraallt.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {
    public enum Categories { ELECTRONICS, FOOD, TOYS, FURNITURE, CLOTHES }

    private Categories category;
    private String title, image, description;
    private Long price;

    public Product(Categories category, String title, String image, String description, Long price) {
        this.category = category;
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}