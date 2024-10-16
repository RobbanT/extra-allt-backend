package com.backend.extraallt.models;

public class PlacedOrder {
    private String username;
    private Order order;

    public PlacedOrder(String userName, Order order) {
        this.username = userName;
        this.order = order;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
