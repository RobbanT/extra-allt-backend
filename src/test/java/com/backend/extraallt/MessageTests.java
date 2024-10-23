package com.backend.extraallt;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.models.Message;
import org.junit.jupiter.api.Test;

public class MessageTests {

    @Test
    public void getContentTest() {
        // Testar olika värden.
        Message message1 = new Message("TEST", null);
        Message message2 = new Message("TEST", "TEST");
        Message message3 = new Message("", "");
        assertTrue(message1.getContent() == null);
        assertTrue(message2.getContent() != null);
        assertTrue(message3.getContent() != null);
    }
}
