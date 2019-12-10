package com.example.proyectofinal.Model;

public class RegisterModel {
    private String username;
    private String email;
    private String first_name;
    private String last_name;
    private String password;

    public RegisterModel(String username, String email, String first, String last, String password) {
        this.username = username;
        this.email = email;
        this.first_name = first;
        this.last_name = last;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst() {
        return first_name;
    }

    public String getLast() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }
}