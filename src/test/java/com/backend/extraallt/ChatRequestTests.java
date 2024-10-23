package com.backend.extraallt;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.models.ChatRequest;
import org.junit.jupiter.api.Test;

public class ChatRequestTests {
    @Test
    public void getMessagesTests() {
        // Kollar om man kan skicka in negativa tal.
        ChatRequest chatRequest1 = new ChatRequest("TEST", "TEST", -5);
        ChatRequest chatRequest2 = new ChatRequest("TEST", "TEST", 0);
        ChatRequest chatRequest3 = new ChatRequest("TEST", "TEST", 5);
        assertTrue(chatRequest1.getN() < 0);
        assertTrue(chatRequest2.getN() == 0);
        assertTrue(chatRequest3.getN() > 0);
    }

}
