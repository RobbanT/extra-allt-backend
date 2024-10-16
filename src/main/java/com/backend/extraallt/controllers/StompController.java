package com.backend.extraallt.controllers;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import com.backend.extraallt.models.*;

@Controller
public class StompController {
    @MessageMapping("/placed")
    @SendTo("/order/placed")
    public PlacedOrder placeOrder(String username, Order order) {
        return new PlacedOrder(username, order);
    }
}
