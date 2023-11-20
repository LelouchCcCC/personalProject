package com.example.demo.utils;

import java.util.List;

public class ItemList {
    private List<String> items;

    public List<String> getItems() {
        return items;
    }


    public void setItems(List<String> items) {
        this.items = items;
    }

    public ItemList() {
    }

    public ItemList(List<String> items) {
        this.items = items;
    }
}
