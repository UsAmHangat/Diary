package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Set;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String text;

    private int mood;

    private String description;
    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}

