package com.example.proyectofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.Interface.PostApi;
import com.example.proyectofinal.Model.AuthModel;
import com.example.proyectofinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button btnIngresar,btnCrearCuenta;
    EditText txtUsuario,txtContraseña;
    String Token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContraseña = findViewById(R.id.txtContraseña);
        txtUsuario = findViewById(R.id.txtUsuario);
        btnIngresar = findViewById(R.id.btnIniciar);
        btnCrearCuenta= findViewById(R.id.btnCrearCuenta);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getToken();
            }
        });
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Register.class);
                startActivity(intent);
            }
        });
    }

    private void getToken() {


        String username = txtUsuario.getText().toString().trim();
        String password = txtContraseña.getText().toString().trim();
        String grant_type = "password";
        String client_id = "1cIffmAYfd7f98cvVlyFhPqJthNuoaYZFpGAJJJ9";
        String client_secret = "nPvA6L7h25zQwxLFq90bKGm2dM8VGTxrZGx98QbJqehmdx1OmW9fRqcD0s0e0VnJzbSmyauel5w7uTnSLDrb9zxq9jz2kwJor3QN0OJA0KdQPNY5qZiZsSDMMzQZQHoj";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<AuthModel> call = postApi.token(grant_type,username,password,client_id,client_secret);

        call.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"ERROR CODIGO: "+response.code(),Toast.LENGTH_LONG);
                    return;
                }
                Token = response.body().getAccess_token().toString();
                Intent intent = new Intent(getApplicationContext(), List.class);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {

            }
        });

    }

}
