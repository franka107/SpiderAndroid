package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.proyectofinal.Interface.PostApi;
import com.example.proyectofinal.Model.FocusModel;
import com.example.proyectofinal.Model.MoveModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Light extends AppCompatActivity {
    Button btnOn,btnOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On();
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Off();
            }
        });

    }

    private void On() {
        int id = 1;
        String id_url = "1";
        String direction      =  "on";

        FocusModel focusModel = new FocusModel(direction,id);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<FocusModel> call = postApi.focusPost(focusModel, id_url);

        call.enqueue(new Callback<FocusModel>() {
            @Override
            public void onResponse(Call<FocusModel> call, Response<FocusModel> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<FocusModel> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }

    private void Off() {
        int id = 1;
        String id_url = "1";
        String direction      =  "off";

        FocusModel focusModel = new FocusModel(direction,id);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<FocusModel> call = postApi.focusPost(focusModel, id_url);

        call.enqueue(new Callback<FocusModel>() {
            @Override
            public void onResponse(Call<FocusModel> call, Response<FocusModel> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<FocusModel> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }
}
