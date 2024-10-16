package com.backend.extraallt.controllers;

import com.backend.extraallt.services.CheckoutService;
import org.springframework.web.bind.annotation.*;
import com.backend.extraallt.models.CartItem;
import java.util.*;

@CrossOrigin("*")
@RestController
public class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/create-checkout-session")
    public Map<String, String> createCheckoutSession(@RequestBody List<CartItem> cart) {
        return checkoutService.createCheckoutSession(cart);
    }
}
