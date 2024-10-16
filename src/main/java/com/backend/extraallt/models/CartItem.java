package com.backend.extraallt.models;

public class CartItem extends Product {
    Long quantity;

    public CartItem(Categories category, String title, String image, String description, Long price, Long quantity) {
        super(category, title, image, description, price);
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
