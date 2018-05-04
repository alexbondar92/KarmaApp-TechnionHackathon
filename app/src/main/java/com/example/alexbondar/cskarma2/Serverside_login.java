package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Serverside_login extends AppCompatActivity {
    EditText pass,username;
    Button login;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serverside_login);
        pass = (EditText)findViewById(R.id.serverside_pass);
        username = (EditText)findViewById(R.id.serverside_username);
        login = (Button)findViewById(R.id.serverside_login);

        signup = (TextView)findViewById(R.id.serverside_signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag=false;
                /*if(!isEmailValid(username.getText().toString())){
                    username.setError("Please enter a valid email address");
                    flag=true;
                }*/
                if(pass.getText().toString().equals("")){
                    pass.setError("Enter a password");
                    flag=true;
                }
                if(!flag){
                    Intent n= new Intent(v.getContext(),OrgDisplayPage.class);
                    startActivity(n);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),Register.class);
                startActivity(a);
                finish();
            }
        });



    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
