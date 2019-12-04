package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {
    Button btnCargar,btnMove;
    ListView lstLista;
    List<String> elementosLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        btnCargar = findViewById(R.id.btnCargar);
        btnMove = findViewById(R.id.btnMove);
        lstLista = findViewById(R.id.lstLista);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Movimientos.class);
                startActivity(intent);
            }
        });
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                elementosLista = new ArrayList<String>();
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://ironspider.pythonanywhere.com/api/currentmovements/";
                JsonArrayRequest stringRequest = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try {
                                    for (int i=0; i<response.length();i++){
                                        String robot = response.getJSONObject(i).getString("robot");
                                        String direction= response.getJSONObject(i).getString("direction");
                                        String data = "R O B O T: \u0009" + robot + "\n" +
                                                "D I R E C T I O N: \u0009" + direction+ "\n";
                                        elementosLista.add(data);
                                    }
                                    ArrayAdapter<String> adaptador =
                                            new ArrayAdapter<String>(getApplicationContext(),
                                                    android.R.layout.simple_list_item_1, elementosLista);
                                    lstLista.setAdapter(adaptador);

                                } catch (JSONException e) {
                                    mostrarAlerta("Error de JSON",
                                            "Se produjo un error al intentar leer la data recibida");
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mostrarAlerta("Error de conexion",
                                "Compuebe que el servicio este activo");
                    }
                });
                queue.add(stringRequest);
            };
        });
    }
    public void mostrarAlerta(String titulo, String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.setPositiveButton("Aceptar", null);
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    public void cargarLista(View v){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                elementosLista = new ArrayList<String>();
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://ironspider.pythonanywhere.com/api/currentmovements/";
                JsonArrayRequest stringRequest = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try {
                                    for (int i=0; i<response.length();i++){
                                        String robot = response.getJSONObject(i).getString("robot");
                                        String direction= response.getJSONObject(i).getString("direction");
                                        String data = "R O B O T: \u0009" + robot + "\n" +
                                                "D I R E C T I O N: \u0009" + direction+ "\n";
                                        elementosLista.add(data);
                                    }
                                    ArrayAdapter<String> adaptador =
                                            new ArrayAdapter<String>(getApplicationContext(),
                                                    android.R.layout.simple_list_item_1, elementosLista);
                                    lstLista.setAdapter(adaptador);

                                } catch (JSONException e) {

                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(stringRequest);
            };
        });
    }

    public void enviarIdMove(View v){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                elementosLista = new ArrayList<String>();
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://ironspider.pythonanywhere.com/api/currentmovements/"+1+"/";
                JsonArrayRequest stringRequest = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try {
                                        String robot = response.getJSONObject(0).getString("robot");
                                        String direction= response.getJSONObject(0).getString("direction");
                                        Bundle parmetros = new Bundle();
                                        parmetros.putString("robot", robot);
                                        Intent i = new Intent(getApplicationContext(), Movimientos.class);
                                        i.putExtras(parmetros);
                                        startActivity(i);

                                } catch (JSONException e) {

                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(stringRequest);
            };
        });
    }

    public void enviarIdDescrption(View v){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                elementosLista = new ArrayList<String>();
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://ironspider.pythonanywhere.com/api/currentmovements/"+1+"/";
                JsonArrayRequest stringRequest = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try {
                                    String robot = response.getJSONObject(0).getString("robot");
                                    String direction= response.getJSONObject(0).getString("direction");
                                    Bundle parmetros = new Bundle();
                                    parmetros.putString("robot", robot);
                                    Intent i = new Intent(getApplicationContext(), Movimientos.class);
                                    i.putExtras(parmetros);
                                    startActivity(i);

                                } catch (JSONException e) {

                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(stringRequest);
            };
        });
    }


}
