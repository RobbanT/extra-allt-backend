package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Autowired;
import com.backend.extraallt.controllers.CheckoutController;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.services.CheckoutService;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class CheckoutControllerTests {
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private CheckoutController checkoutController = new CheckoutController(checkoutService);

    @Test
    public void createCheckoutSession() {
        assertTrue(checkoutController.createCheckoutSession("Roberto", null).size() == 0);
    }
}
