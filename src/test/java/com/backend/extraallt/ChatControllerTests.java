package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.controllers.ChatController;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class ChatControllerTests {
    @Autowired
    private ChatController chatController;

    @Test
    public void postChatTest() {
        // Kontrollerar om man kan skicka in en tom textsträng.
        assertTrue(chatController.postChat("") instanceof String);
    }
}
