package com.example.proyectofinal.Interface;


import com.example.proyectofinal.Model.AuthModel;
import com.example.proyectofinal.Model.FocusModel;
import com.example.proyectofinal.Model.MoveModel;
import com.example.proyectofinal.Model.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostApi {

    String MY_URL = "http://ironspider.pythonanywhere.com/";

    @PUT("api/currentmovements/{id}/")
    Call<MoveModel> movePost(@Body MoveModel moveModel, @Path(value = "id", encoded = true) String id);

    @POST("api/register/")
    Call<RegisterModel> registerPost(@Body RegisterModel registerModel);

    @FormUrlEncoded
    @Headers({
            "Content-Type: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("o/token/")
    Call<AuthModel> token(@Field(value="grant_type",encoded = true) String grant_type, @Field(value="username",encoded = true) String username,
                          @Field(value = "password",encoded = true) String password, @Field(value = "client_id",encoded = true) String client_id,
                          @Field(value = "client_secret",encoded = true) String client_secret);

    @PUT("api/channels/{id}/")
    Call<FocusModel> focusPost(@Body FocusModel focusModel, @Path(value = "id", encoded = true) String id);
}