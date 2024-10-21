package com.backend.extraallt.controllers;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import com.backend.extraallt.models.*;

@Controller
public class StompController {
    // Används när vi vill informera alla besökare på webbshoppen att någon har lagt en order. 
    @MessageMapping("/placed")
    @SendTo("/order/placed")
    public PlacedOrder placeOrder(String username, Order order) {
        return new PlacedOrder(username, order);
    }
}
