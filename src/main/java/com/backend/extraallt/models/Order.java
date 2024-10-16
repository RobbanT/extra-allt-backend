package com.backend.extraallt.models;

import java.util.List;
import java.time.*;

public class Order {
    private String id, timeCreated;
    private List<CartItem> cartItems;

    public Order(String id, List<CartItem> cartItems) {
        this.id = id;
        this.timeCreated = LocalDateTime.now(ZoneId.of("Europe/Paris")).toString();
        this.cartItems = cartItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}