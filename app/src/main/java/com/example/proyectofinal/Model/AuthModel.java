package com.example.proyectofinal.Model;

public class AuthModel {

    private String access_token;
    private int expires_in;
    private String token_type;
    private String scope;
    private String refresh_token;


    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getScope() {
        return scope;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
