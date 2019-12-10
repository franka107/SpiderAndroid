package com.example.proyectofinal.Model;

public class CredentialModel {
    private String grant_type;
    private String username;
    private String client_id;
    private String client_secret;
    private String password;

    public CredentialModel(String grant_type, String username, String password, String client_id, String client_secret) {

        this.grant_type = grant_type;
        this.username = username;
        this.password = password;
        this.client_id = client_id;
        this.client_secret = client_secret;

    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getUsername() {
        return username;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getPassword() {
        return password;
    }
}