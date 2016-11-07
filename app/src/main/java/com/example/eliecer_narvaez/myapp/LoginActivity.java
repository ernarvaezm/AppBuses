package com.example.eliecer_narvaez.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.example.eliecer_narvaez.myapp.models.ProvinciaService;
import com.example.eliecer_narvaez.myapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText pass;
    EditText email;
    TextView response1;
    Button OKBu;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pass=(EditText)findViewById(R.id.pass);
        email=(EditText)findViewById(R.id.username);
        OKBu=(Button)findViewById(R.id.btnOK);


    }

    public void selfDestruct(View view) {

        /**
         *
         *

        ProvinciaService service = ProvinciaService.retrofit.create(ProvinciaService.class);
        User user =new User();
        user.setEmail(email.getText().toString());
        user.setPassword(pass.getText().toString());
        Call<Object> call = service.log2(user);

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, retrofit2.Response<Object> response) {
                if (response.code()==200){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    String text= "Incorrect Credentials.Try again";

                    int duration = Toast.LENGTH_LONG;
                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                String text= t.toString();
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }

        });
         *
         */
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void register(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActitvity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActitvity.class);
        startActivity(intent);
        finish();
        }

}
