package com.backend.extraallt.models;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document(collection = "Users")
public class User {
    private String username, password;
    private List<Order> orders;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.orders = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}