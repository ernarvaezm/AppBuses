package com.example.eliecer_narvaez.myapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.AdapterView;

import com.example.eliecer_narvaez.myapp.models.*;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.String;


import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;


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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        ProvinciaService gitHubService = ProvinciaService.retrofit.create(ProvinciaService.class);
        Call<List<Ruta>> call = gitHubService.getRutas();

        call.enqueue(new Callback<List<Ruta>>() {
            @Override
            public void onResponse(Call<List<Ruta>> call, retrofit2.Response<List<Ruta>> response) {

                fillSpinnerRutas(response.body());
            }

            @Override
            public void onFailure(Call<List<Ruta>> call, Throwable t) {
                text.setText("Something went wrong: " + t.getMessage());
            }

        });

        Call<List<Empresa>> callCompanies = gitHubService.getEmpresas();

        callCompanies.enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, retrofit2.Response<List<Empresa>> response) {

                fillSpinnerEmpresas(response.body());

            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                text.setText("Something went wrong: " + t.getMessage());
            }

        });


    }


    public void next(View view) {



        Intent intent = new Intent(BusesActivity.this, MapActivity.class);
        //intent.putExtra("placa",board.getText().toString()
        startActivity(intent);
        finish();
    }
    public void fillSpinnerRutas(List<Ruta> myList){
         Spinner spinner = (Spinner) findViewById(R.id.spinRutas);
        ArrayAdapter<Ruta> spinnerAdapter = new ArrayAdapter<Ruta>(this, R.layout.spinner, R.id.text,myList);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                       // provin= (() parent.getSelectedItem());
                        // fillCantones(provin.getId());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }

                });


    }

    public void fillSpinnerEmpresas(List<Empresa> myList){
        Spinner spinner = (Spinner) findViewById(R.id.spinEmpresas);
        ArrayAdapter<Empresa> spinnerAdapter = new ArrayAdapter<Empresa>(this, R.layout.spinner, R.id.text,myList);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // provin= (() parent.getSelectedItem());
                // fillCantones(provin.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }

        });


    }


}
