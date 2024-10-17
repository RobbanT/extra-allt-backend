package com.backend.extraallt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import com.backend.extraallt.controllers.UserController;
import com.backend.extraallt.models.User;
import com.backend.extraallt.services.UserService;

public class UserControllerTests {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserController userController;
    private User user1, user2, user3, user4, user5;

    @BeforeAll
    public void setUp() {
        userController = new UserController(userService);
        user1 = new User("Kalle1", "123456");
        user2 = new User("Kalle2", "123456");
        user3 = new User("Kalle3", "123456");
        user4 = new User("Kalle4", "123456");
        user5 = new User("Kalle5", "123456");
    }

    @Test
    public void addUser() {
        // Test för att se om en användare registreras.
        assertTrue(userController.setUser(user1) != null);
        assertTrue(userController.setUser(user1) == null);
        assertTrue(userController.setUser(user2) != null);
        assertTrue(userController.setUser(user3) != null);
        assertTrue(userController.setUser(user4) != null);
        assertTrue(userController.setUser(user5) != null);
    }

    @Test
    public void login() {
        // Test för att se om en användare kan logga in.
        assertTrue(userController.getUser(user1.getUsername(), user2.getPassword()) != null);
        assertTrue(userController.getUser(user2.getUsername(), user2.getPassword()) != null);
        assertTrue(userController.getUser(user3.getUsername(), user2.getPassword()) != null);
        assertTrue(userController.getUser(user4.getUsername(), user2.getPassword()) != null);
        assertTrue(userController.getUser(user5.getUsername(), user2.getPassword()) != null);
    }
}
