package com.example.eliecer_narvaez.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;


import com.example.eliecer_narvaez.myapp.models.ConnectionService;
import com.example.eliecer_narvaez.myapp.models.User;


import retrofit2.Call;
import retrofit2.Callback;

import org.json.JSONArray;

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

       ConnectionService service = ConnectionService.retrofit.create(ConnectionService.class);
       User user =new User();
       user.setEmail(email.getText().toString());
       user.setPassword(pass.getText().toString());
       user.setName(name.getText().toString());
       Call<JSONArray> call = service.register(user);

       call.enqueue(new Callback<JSONArray>() {
           @Override
           public void onResponse(Call<JSONArray> call, retrofit2.Response<JSONArray> response) {

               if (response.code()!=201){

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
           public void onFailure(Call<JSONArray> call, Throwable t) {
               String text= "Something Wrong "+t.toString();

               int duration = Toast.LENGTH_LONG;
               Context context = getApplicationContext();

               Toast toast = Toast.makeText(context, text, duration);
               toast.show();
           }

       });

   }
}
