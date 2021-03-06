package com.example.eliecer_narvaez.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;

import com.example.eliecer_narvaez.myapp.models.*;

import java.lang.String;
import android.widget.Toast;
import android.content.Context;



import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
public class buses2Activity extends AppCompatActivity {

    private  int ruta_id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses3);
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
        Spinner spinner = (Spinner) findViewById(R.id.spinnerRutas);
        ArrayAdapter<Ruta> spinnerAdapter = new ArrayAdapter<Ruta>(this, R.layout.spinner, R.id.text,myList);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 Ruta ruta= ((Ruta) parent.getSelectedItem());
                ruta_id=ruta.getId();
                fillSpinnerCompany(ruta.getId());
                 fillSpinnerSchedule(ruta.getId());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }

        });


    }
    public void fillSpinnerEmpresas(List<Empresa> myList){
        Spinner spinner = (Spinner) findViewById(R.id.spinnerEmpresas);
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
                Context context = getApplicationContext();

                CharSequence text = "nOTHINFD SELWE";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });
    }
    public void fillSpinnerSchedule(int id){

        ConnectionService g = ConnectionService.retrofit.create(ConnectionService.class);
        Call<List<Horario>> call = g.getHorarios(id);

        call.enqueue(new Callback<List<Horario>>() {
            @Override
            public void onResponse(Call<List<Horario>> call, retrofit2.Response<List<Horario>> response) {
                if(response.code()==422){
                    Spinner spinner = (Spinner) findViewById(R.id.spinnerHorarios);
                    spinner.setAdapter(null);
                    Context context = getApplicationContext();

                    CharSequence text = "Esta ruta no tiene horarios asociados!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if (response.code()==200){
                    loadData(response.body());
                }


            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {
                Context context = getApplicationContext();

                CharSequence text = "ERROR !"+t.toString();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }

        });

    }
    public void fillSpinnerCompany(int id){

        ConnectionService g = ConnectionService.retrofit.create(ConnectionService.class);
        Call<List<Empresa>> call = g.getEmpresas(id);

        call.enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, retrofit2.Response<List<Empresa>> response) {

                if(response.code()==422){
                    Spinner spinner = (Spinner) findViewById(R.id.spinnerEmpresas);
                    spinner.setAdapter(null);
                    Context context = getApplicationContext();

                    CharSequence text = "Esta ruta no tiene empresas asociadas!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if(response.code()==200){
                    loadDataCompany(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                Context context = getApplicationContext();

                CharSequence text = "ERROR !"+t.toString();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }

        });

    }

    private void loadData(  List<Horario> myList){

        Spinner spinner = (Spinner) findViewById(R.id.spinnerHorarios);
        ArrayAdapter<Horario> spinnerAdapter = new ArrayAdapter<Horario>(this, R.layout.spinner, R.id.text,myList);
        spinner.setAdapter(spinnerAdapter);
    }
    private void loadDataCompany( List<Empresa> myList){

        Spinner spinner = (Spinner) findViewById(R.id.spinnerEmpresas);
        ArrayAdapter<Empresa> spinnerAdapter = new ArrayAdapter<Empresa>(this, R.layout.spinner, R.id.text,myList);
        spinner.setAdapter(spinnerAdapter);
    }

    public  void next(View view){
        Intent intent =new Intent(buses2Activity.this,MapActivity.class);
        intent.putExtra("ruta_id",String.valueOf(ruta_id));
        startActivity(intent);

    }

}
