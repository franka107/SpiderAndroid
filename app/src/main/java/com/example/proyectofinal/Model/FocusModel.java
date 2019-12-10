package com.example.proyectofinal.Model;

public class FocusModel {
    private int id;
    private String value;

    public FocusModel(String value , int id) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}