package com.indexingpipeline.common;

import com.google.gson.Gson;

public class Event {
    private final String id;
    private final String title;
    private final String description;
    private final double price;

    public Event(String id, String title, String description, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
