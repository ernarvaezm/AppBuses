package com.example.eliecer_narvaez.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BusesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses);
        Spinner spinner=(Spinner)findViewById(R.id.spinnerDestinations);
        String[] list =getResources().getStringArray(R.array.destinations_array);
        ArrayAdapter<String>adapter =new ArrayAdapter<String>(this,R.layout.spinner,R.id.text,list);
        spinner.setAdapter(adapter);

        Spinner spinnerCompanies=(Spinner)findViewById(R.id.spinnerCompanies);
        String[] listCompanies =getResources().getStringArray(R.array.companies_array);
        ArrayAdapter<String>adapterCompanies =new ArrayAdapter<String>(this,R.layout.spinner,R.id.text,listCompanies);
        spinnerCompanies.setAdapter(adapterCompanies);



    }


}
