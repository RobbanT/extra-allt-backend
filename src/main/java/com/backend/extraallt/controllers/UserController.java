package com.backend.extraallt.controllers;

import com.backend.extraallt.services.UserService;
import org.springframework.web.bind.annotation.*;
import com.backend.extraallt.models.*;
import java.util.*;

@CrossOrigin("*")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Hämtar en användare.
    @GetMapping("/user/{username}/{password}")
    public User getUser(@PathVariable String username, @PathVariable String password) {
        return userService.getUser(username, password);
    }

    // Skapar en användare.
    @PostMapping("/user")
    public User setUser(@RequestBody User user) {
        return userService.setUser(user);
    }

    // Hämtar en order för en viss användare.
    @GetMapping("/user/{username}/order/{id}")
    public Order getOrders(@PathVariable String username, @PathVariable String id) {
        return userService.getOrder(username, id);
    }

    // Hämtar alla ordrar för en viss användare.
    @GetMapping("/user/{username}/orders")
    public List<Order> getOrders(@PathVariable String username) {
        return userService.getOrders(username);
    }

    // Skapar en order för en viss användare.
    @PostMapping("/user/{username}/order")
    public Order setPost(@PathVariable String username, @RequestBody Order order) {
        return userService.setOrder(username, order);
    }
}
