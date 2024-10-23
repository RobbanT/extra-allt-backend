package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.controllers.UserController;
import com.backend.extraallt.services.UserService;
import com.backend.extraallt.models.User;
import org.junit.jupiter.api.Test;
import java.util.UUID;

@SpringBootTest
public class UserControllerTests {
    @Autowired
    private UserService userService;
    @Autowired
    private UserController userController = new UserController(userService);

    @Test
    public void addUser() {
        // Test för att se om en användare registreras.
        User user1 = new User(UUID.randomUUID().toString(), "123456");
        User user2 = new User(UUID.randomUUID().toString(), "123456");
        User user3 = new User(UUID.randomUUID().toString(), "123456");
        assertTrue(userController.setUser(user1) != null);
        assertTrue(userController.setUser(user2) != null);
        assertTrue(userController.setUser(user3) != null);
        // Kan inte registrera en användare med samma användarnamn.
        assertTrue(userController.setUser(user3) == null);
    }

    @Test
    public void login() {
        // Test för att se om en användare kan logga in.
        User user1 = new User("Roberto", "123456");
        // Kommer inte kunna logga in denna användare då den inte är registrerad.
        User user2 = new User(UUID.randomUUID().toString(), "123456");
        assertTrue(userController.getUser(user1.getUsername(), "123456") != null);
        assertTrue(userController.getUser(user2.getUsername(), "123456") == null);
    }
}
