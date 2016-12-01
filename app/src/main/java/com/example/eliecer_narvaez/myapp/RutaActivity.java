package com.example.eliecer_narvaez.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.eliecer_narvaez.myapp.models.ConnectionService;
import com.example.eliecer_narvaez.myapp.models.Ruta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class RutaActivity extends AppCompatActivity {
    String businessType[] = { "Automobile", "Food", "Computers", "Education",
            "Personal", "Travel" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);
        ConnectionService gitHubService = ConnectionService.retrofit.create(ConnectionService.class);
        Call<List<Ruta>> call = gitHubService.getRutas();

        call.enqueue(new Callback<List<Ruta>>() {
            @Override
            public void onResponse(Call<List<Ruta>> call, retrofit2.Response<List<Ruta>> response) {

                fillSpinnerRutas(response.body());
            }

            @Override
            public void onFailure(Call<List<Ruta>> call, Throwable t) {

            }

        });
    }
    public void fillSpinnerRutas(List<Ruta> myList){


        Spinner spinner = (Spinner) findViewById(R.id.spCountries);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, R.id.text,businessType);
        spinner.setAdapter(spinnerAdapter);


    }
}
