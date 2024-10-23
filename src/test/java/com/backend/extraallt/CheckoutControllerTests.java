package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Autowired;
import com.backend.extraallt.controllers.CheckoutController;
import com.backend.extraallt.models.CartItem;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.services.CheckoutService;
import org.junit.jupiter.api.Test;
import java.util.*;

@SpringBootTest
public class CheckoutControllerTests {
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private CheckoutController checkoutController = new CheckoutController(checkoutService);

    @Test
    public void createCheckoutSession() {
        // Kollar om man kan skicka in en tom varukorg.
        assertTrue(checkoutController.createCheckoutSession("Roberto", null).isEmpty());
        assertTrue(checkoutController.createCheckoutSession("Roberto", new ArrayList<CartItem>()).isEmpty());
    }
}
