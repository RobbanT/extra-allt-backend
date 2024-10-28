package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.controllers.StompController;
import com.backend.extraallt.services.StompService;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class StompControllerTests {
    @Autowired
    private StompService stompService;
    @Autowired
    private StompController stompController = new StompController(stompService);

    @Test
    public void placeOrderTest() {
        // Kontrollerar om man kan placera en order utan användarnamn.
        assertTrue(stompController.placeOrder("") != null);
        assertTrue(stompController.placeOrder(null) == null);
    }
}
