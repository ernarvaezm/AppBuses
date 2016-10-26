package com.example.eliecer_narvaez.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;


import com.example.eliecer_narvaez.myapp.models.ProvinciaService;
import com.example.eliecer_narvaez.myapp.models.User;
import com.google.gson.JsonArray;



import retrofit2.Call;
import retrofit2.Callback;
import com.google.gson.JsonArray;

public class RegisterActitvity extends AppCompatActivity {
    EditText pass;
    EditText email;
    EditText name;

    Button OKBu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_actitvity);
        pass=(EditText)findViewById(R.id.textPassword);
        email=(EditText)findViewById(R.id.textEmail);
        name=(EditText)findViewById(R.id.textName);
        OKBu=(Button)findViewById(R.id.btnRegister);

    }

   public void register(View view){

       ProvinciaService service = ProvinciaService.retrofit.create(ProvinciaService.class);
       User user =new User();
       user.setEmail(email.getText().toString());
       user.setPassword(pass.getText().toString());
       user.setName(name.getText().toString());
       Call<JsonArray> call = service.register(user);

       call.enqueue(new Callback<JsonArray>() {
           @Override
           public void onResponse(Call<JsonArray> call, retrofit2.Response<JsonArray> response) {
               if (response.code()!=201){
                   JsonArray ja = new JsonArray();


                   String text= "Incorrect Data ,Try again";

                   int duration = Toast.LENGTH_LONG;
                   Context context = getApplicationContext();

                   Toast toast = Toast.makeText(context, text, duration);
                   toast.show();
               }else {
                   Intent intent = new Intent(RegisterActitvity.this, MainActivity.class);
                   startActivity(intent);
                   finish();
               }


           }

           @Override
           public void onFailure(Call<JsonArray> call, Throwable t) {
               String text= "Something Wrong "+t.toString();

               int duration = Toast.LENGTH_LONG;
               Context context = getApplicationContext();

               Toast toast = Toast.makeText(context, text, duration);
               toast.show();
           }

       });

   }
}
