package com.backend.extraallt.models;

import java.util.List;

public class ChatResponse {
    private List<Choice> choices;

    public ChatResponse() {
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {
        private Message message;

        private Choice() {
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }
}
