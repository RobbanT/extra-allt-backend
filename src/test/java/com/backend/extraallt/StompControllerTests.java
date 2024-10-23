package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.controllers.StompController;
import com.backend.extraallt.services.StompService;
import com.backend.extraallt.models.*;
import org.junit.jupiter.api.Test;
import java.util.*;

@SpringBootTest
public class StompControllerTests {
    @Autowired
    private StompService stompService;
    @Autowired
    private StompController stompController = new StompController(stompService);

    @Test
    public void placeOrderTest() {
        // Kontrollerar om man kan placera en order utan produkter.
        assertTrue(stompController.placeOrder("Roberto", new Order(null)) != null);
        assertTrue(stompController.placeOrder("Roberto", new Order(new ArrayList<CartItem>())).size() > 0);
    }
}
