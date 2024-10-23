package com.backend.extraallt;

import static org.junit.jupiter.api.Assertions.*;
import com.backend.extraallt.models.User;
import org.junit.jupiter.api.Test;

public class UserTests {
    @Test
    public void getOrdersTest() {
        // Testar så att varje användare verkligen skapas utan ordrar.
        User user = new User("Test", "Test");
        assertTrue(user.getOrders().isEmpty());
        assertFalse(!user.getOrders().isEmpty());
    }
}
