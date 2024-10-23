package com.backend.extraallt.controllers;

import org.springframework.messaging.handler.annotation.*;
import com.backend.extraallt.services.StompService;
import org.springframework.stereotype.Controller;
import com.backend.extraallt.models.*;
import java.util.Map;

@Controller
public class StompController {
    private final StompService stompService;

    public StompController(StompService stompService) {
        this.stompService = stompService;
    }

    // Används när vi vill informera alla besökare på webbshoppen att någon har lagt
    // en order.
    @MessageMapping("/placed")
    @SendTo("/order/placed")
    public Map<String, Order> placeOrder(String username, Order order) {
        return stompService.placeOrder(username, order);
    }
}
