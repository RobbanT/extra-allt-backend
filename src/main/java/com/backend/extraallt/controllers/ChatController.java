package com.backend.extraallt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.backend.extraallt.services.ChatService;
import com.backend.extraallt.models.ChatResponse;
import org.springframework.web.bind.annotation.*;

public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public String postChat(@RequestBody String prompt) {
        ChatResponse response = chatService.sendChatResponse(prompt);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
