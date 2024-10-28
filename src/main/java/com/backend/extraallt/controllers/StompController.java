package com.backend.extraallt.controllers;

import org.springframework.messaging.handler.annotation.*;
import com.backend.extraallt.services.StompService;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {
    private final StompService stompService;

    public StompController(StompService stompService) {
        this.stompService = stompService;
    }

    // Används när vi vill informera alla besökare på webbshoppen att någon har lagt en order.
    @MessageMapping("/placed")
    @SendTo("/order/placed")
    public String placeOrder(String username) {
        return stompService.placeOrder(username);
    }
}
