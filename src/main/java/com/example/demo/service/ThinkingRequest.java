package com.example.demo.service;

import com.example.demo.urlRoute.Thinking;

import java.util.List;

public class ThinkingRequest {
    private Thinking thinking;
    private List<String> items;

    public Thinking getThinking() {
        return thinking;
    }

    public void setThinking(Thinking thinking) {
        this.thinking = thinking;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public ThinkingRequest(Thinking thinking, List<String> items) {
        this.thinking = thinking;
        this.items = items;
    }

    public ThinkingRequest() {
    }
}