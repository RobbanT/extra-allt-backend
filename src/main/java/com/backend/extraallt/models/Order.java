package com.backend.extraallt.models;

import java.util.*;
import java.time.*;

public class Order {
    private String id, timeCreated;
    private List<CartItem> cartItems;
    private int totalSum;

    public Order(List<CartItem> cartItems) {
        this.id = UUID.randomUUID().toString();
        this.timeCreated = LocalDateTime.now(ZoneId.of("Europe/Paris")).toString();
        this.cartItems = cartItems;
        if (cartItems != null) {
            for (CartItem cartItem : this.cartItems) {
                this.totalSum += cartItem.getPrice() * cartItem.getQuantity();
            }
        } else {
            this.totalSum = 0;
        }

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

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }
}