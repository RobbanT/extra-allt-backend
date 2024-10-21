package com.backend.extraallt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.backend.extraallt.services.ChatService;
import com.backend.extraallt.models.ChatResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    // Används för att kommunicera med vår AI.
    @PostMapping("/chat")
    public String postChat(@RequestBody String prompt) {
        ChatResponse response = chatService.sendChatResponse(prompt);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
