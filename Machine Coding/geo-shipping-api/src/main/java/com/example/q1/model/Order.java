package com.example.q1.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;
    
    public Order() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    
}
