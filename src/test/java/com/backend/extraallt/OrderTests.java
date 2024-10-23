package com.backend.extraallt;

import static org.junit.jupiter.api.Assertions.*;
import com.backend.extraallt.models.CartItem;
import com.backend.extraallt.models.Order;
import org.junit.jupiter.api.Test;
import java.util.*;

public class OrderTests {
    @Test
    public void getCartItemsTest() {
        // Kan man skapa en order utan produkter?
        Order order = new Order(new ArrayList<CartItem>());
        assertTrue(order.getCartItems().isEmpty());
        assertFalse(order.getCartItems().size() > 0);
    }
}
