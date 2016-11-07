package com.example.eliecer_narvaez.myapp;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.AdapterView;

import com.example.eliecer_narvaez.myapp.models.*;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.String;


import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

import java.io.IOException;


public class BusesActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    TextView text;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses);
        //text = (TextView) findViewById(R.id.textView4);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        ProvinciaService gitHubService = ProvinciaService.retrofit.create(ProvinciaService.class);
        Call<List<Provincia>> call = gitHubService.getProvincias();

        call.enqueue(new Callback<List<Provincia>>() {
            @Override
            public void onResponse(Call<List<Provincia>> call, retrofit2.Response<List<Provincia>> response) {

                fillSpinnerProvincia(response.body());
            }

            @Override
            public void onFailure(Call<List<Provincia>> call, Throwable t) {
                text.setText("Something went wrong: " + t.getMessage());
            }

        });
        spinnerRutas();

    }


    public void next(View view) {



        Intent intent = new Intent(BusesActivity.this, MapActivity.class);
        //intent.putExtra("placa",board.getText().toString()
        startActivity(intent);
        finish();
    }
    public void fillSpinnerProvincia(List<Provincia> myList){
         Spinner spinner = (Spinner) findViewById(R.id.spinProvincias);
        ArrayAdapter<Provincia> spinnerAdapter = new ArrayAdapter<Provincia>(this, R.layout.spinner, R.id.text,myList);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       Provincia provin= ((Provincia) parent.getSelectedItem());

                        fillCantones(provin.getId());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }

                });
/* Create your ArrayList collection using StringWithTag instead of String.



 //Traversing through the whole list to get all the names
        for(int i=0; i<myList.size(); i++){
            //Storing names to string array
            items[i] = myList.get(i).getNombre();
        }
          String[] items = new String[myList.size()];


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinnerMap);
        //setting adapter to spinner
        spinner.setAdapter(adapter);


 */

    }
    public void fillCantones(int  id){

        ProvinciaService gitHubService = ProvinciaService.retrofit.create(ProvinciaService.class);
        Call<List<Canton>> call = gitHubService.getCantones(id);

        call.enqueue(new Callback<List<Canton>>() {
            @Override
            public void onResponse(Call<List<Canton>> call, retrofit2.Response<List<Canton>> response) {

                spinnerCantones(response.body());
            }

            @Override
            public void onFailure(Call<List<Canton>> call, Throwable t) {
                text.setText("Something went wrong: " + t.getMessage());
            }

        });

    }
    void  spinnerCantones(List<Canton> myList){

        Spinner spinner = (Spinner) findViewById(R.id.spinCantones);
        ArrayAdapter<Canton> spinnerAdapter = new ArrayAdapter<Canton>(this, R.layout.spinner, R.id.text,myList);
        spinner.setAdapter(spinnerAdapter);

    }
    void spinnerRutas(){
        ProvinciaService gitHubService = ProvinciaService.retrofit.create(ProvinciaService.class);
        Call<List<Ruta>> call = gitHubService.getRutas();

        call.enqueue(new Callback<List<Ruta>>() {


            @Override
            public void onResponse(Call<List<Ruta>> call, retrofit2.Response<List<Ruta>> response) {
            rutas(response.body());

            }

            @Override
            public void onFailure(Call<List<Ruta>> call, Throwable t) {
                text.setText("Something went wrong: " + t.getMessage());
            }

        });
    }
    public void rutas(List<Ruta> myList){
        Spinner spinner = (Spinner) findViewById(R.id.spinRutas);

        ArrayAdapter<Ruta> spinnerAdapter = new ArrayAdapter<Ruta>(this, R.layout.spinner, R.id.text, myList);
        spinner.setAdapter(spinnerAdapter);
    }

}
