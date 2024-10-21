package com.backend.extraallt.models;

import java.util.*;

public class ChatRequest {
    private String model;
    private List<Message> messages;
    private int n;

    public ChatRequest(String model, String prompt, int n) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("system",
                "Du är ett butiksbiträde för en webbshop som säljer elektronikprodukter, leksaker, mat, kläder och möbler. Om du ska rekommendera en vara så rekommendera Popcorn för det är billigt och bra."));
        this.messages.add(new Message("user", prompt));
        this.n = n;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
