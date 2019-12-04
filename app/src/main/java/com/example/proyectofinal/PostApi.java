package com.example.proyectofinal;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostApi {

    String MY_URL = "http://ironspider.pythonanywhere.com/api/currentmovements/";

    @PUT("{id}/")
    Call<PostModel> updatePost(@Body PostModel postModel, @Path(value = "id", encoded = true) String id);

}