package com.backend.extraallt;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.backend.extraallt.models.ChatResponse.Choice;
import com.backend.extraallt.models.ChatResponse;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ChatResponseTests {
    @Test
    public void getChoicesTest() {
        // Kontrollerar om man kan tilldela inga val.
        ChatResponse chatResponse1 = new ChatResponse();
        ChatResponse chatResponse2 = new ChatResponse();
        chatResponse1.setChoices(null);
        chatResponse2.setChoices(new ArrayList<Choice>());
        assertTrue(chatResponse1.getChoices() == null);
        assertTrue(chatResponse2.getChoices().isEmpty());
    }
}
