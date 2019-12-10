package com.example.proyectofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.proyectofinal.Interface.PostApi;
import com.example.proyectofinal.Model.MoveModel;
import com.example.proyectofinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Move extends AppCompatActivity {

    ImageButton btnUp,btnLeft,btnDown,btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        btnUp = findViewById(R.id.btnUp);
        btnDown = findViewById(R.id.btnDown);
        btnRight = findViewById(R.id.btnRight);
        btnLeft = findViewById(R.id.btnLeft);

        btnUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Up();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Stop();
                }
                return true;
            }
        });

        btnDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Down();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Stop();
                }
                return true;
            }
        });

        btnRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Right();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Stop();
                }
                return true;
            }
        });

        btnLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Left();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Stop();
                }
                return true;
            }
        });

    }
    private void Up() {
        int robot=1;
        String id = "1";
        String direction      =  "Front";

        MoveModel moveModel = new MoveModel(direction,robot);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<MoveModel> call = postApi.movePost(moveModel, id);

        call.enqueue(new Callback<MoveModel>() {
            @Override
            public void onResponse(Call<MoveModel> call, Response<MoveModel> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<MoveModel> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }

    private void Down() {
        int robot=1;
        String id = "1";
        String direction      =  "Back";

        MoveModel moveModel = new MoveModel(direction,robot);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<MoveModel> call = postApi.movePost(moveModel, id);

        call.enqueue(new Callback<MoveModel>() {
            @Override
            public void onResponse(Call<MoveModel> call, Response<MoveModel> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<MoveModel> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }

    private void Left() {
        int robot=1;
        String id = "1";
        String direction      =  "Left";

        MoveModel moveModel = new MoveModel(direction,robot);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<MoveModel> call = postApi.movePost(moveModel, id);

        call.enqueue(new Callback<MoveModel>() {
            @Override
            public void onResponse(Call<MoveModel> call, Response<MoveModel> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<MoveModel> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }

    private void Right() {
        int robot=1;
        String id = "1";
        String direction      =  "Right";

        MoveModel moveModel = new MoveModel(direction,robot);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<MoveModel> call = postApi.movePost(moveModel, id);

        call.enqueue(new Callback<MoveModel>() {
            @Override
            public void onResponse(Call<MoveModel> call, Response<MoveModel> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<MoveModel> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }

    private void Stop() {
        int robot=1;
        String id = "1";
        String direction = "Stop";

        MoveModel moveModel = new MoveModel(direction,robot);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<MoveModel> call = postApi.movePost(moveModel, id);

        call.enqueue(new Callback<MoveModel>() {
            @Override
            public void onResponse(Call<MoveModel> call, Response<MoveModel> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<MoveModel> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }
}
