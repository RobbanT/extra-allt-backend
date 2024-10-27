package com.backend.extraallt.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;
import com.backend.extraallt.models.*;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder bcryptEncoder;
    private final MongoOperations mongoOperations;

    public UserService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    private User findUser(String username) {
        return mongoOperations.findOne(new Query().addCriteria(Criteria.where("username").is(username)), User.class);
    }

    public User getUser(String username, String password) {
        return findUser(username) != null &&
                bcryptEncoder.matches(password, findUser(username).getPassword()) ? findUser(username) : null;
    }

    public User setUser(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return findUser(user.getUsername()) != null ? null : mongoOperations.insert(user);
    }

    public Order getOrder(String username, String id) {
        return (Order) findUser(username).getOrders().stream().filter(order -> order.getId().equals(id)).toArray()[0];
    }

    public List<Order> getOrders(String username) {
        return findUser(username).getOrders();
    }

    public Order setOrder(String username, Order order) {
        User user = findUser(username);
        user.getOrders().add(order);
        mongoOperations.updateFirst(new Query().addCriteria((Criteria.where("username").is(username))),
                Update.update("orders", user.getOrders()), User.class);
        return order;
    }
}
