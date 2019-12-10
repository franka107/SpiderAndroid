package com.example.proyectofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.Interface.PostApi;
import com.example.proyectofinal.Model.RegisterModel;
import com.example.proyectofinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    EditText txtUsuario,txtNombres,txtApellidos,txtCorreo,txtContraseña;
    Button btnRegistar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnRegistar = findViewById(R.id.btnRegistrar);

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPost();
            }
        });

    }

    private void registerPost() {

        String username= txtUsuario.getText().toString().trim();
        String email= txtCorreo.getText().toString().trim();;
        String first_name=txtNombres.getText().toString();
        String last_name=txtApellidos.getText().toString();
        String password=txtContraseña.getText().toString().trim();;

        RegisterModel registerModel= new RegisterModel(username,email,first_name,last_name,password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<RegisterModel> call = postApi.registerPost(registerModel);

        call.enqueue(new Callback<RegisterModel>() {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {

                Toast.makeText(getApplicationContext(),"Su usuario fue correctamente registrado " + response.code()+response.body()+response.errorBody(),Toast.LENGTH_LONG).show();
                Intent intent =  new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Hubo un error al intentar registrar al usuario",Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
