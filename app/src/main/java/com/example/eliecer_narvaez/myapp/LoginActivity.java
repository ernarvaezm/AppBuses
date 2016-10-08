package com.example.eliecer_narvaez.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText pass;
    EditText user;
    EditText response;
    Button OKBu;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pass=(EditText)findViewById(R.id.pass);
        response=(EditText)findViewById(R.id.response);
        user=(EditText)findViewById(R.id.username);
        OKBu=(Button)findViewById(R.id.btnOK);


    }

    public void selfDestruct(View view) {

        startActivity(new Intent(LoginActivity.this, MainActivity.class));


//                if (user.getText().toString().equals("cisco")){
//
//
//                }else{
//                    response.setText("error");
//                }
    }

    @Override
    public void onClick(View v) {

        }

}
