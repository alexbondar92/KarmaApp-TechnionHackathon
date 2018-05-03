package com.example.alexbondar.cskarma2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText firstname,lastname,email,pw1,pw2,phone;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname);
        email=(EditText)findViewById(R.id.email);
        pw1=(EditText)findViewById(R.id.pw1);
        pw2=(EditText)findViewById(R.id.pw2);
        phone=(EditText)findViewById(R.id.phone);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstname.getText().toString().equals("")){
                    firstname.setError("Please enter a first name");
                }
                if(lastname.getText().toString().equals("")){
                    lastname.setError("Please enter a last name");
                }
                if(!isEmailValid(email.getText().toString())){
                    email.setError("Please enter a valid email address");
                }
                if(pw1.getText().toString().equals("")&& !pw1.getText().toString().equals(pw2.getText().toString())){
                    if(pw1.getText().toString().equals("")){
                        pw1.setError("Password cannot be empty");
                    }
                    pw1.setError("Password does not match");
                    pw2.setError("Password does not match");
                }
                if(!isPhoneValid(phone.getText().toString())){
                    phone.setError("Please enter a valid phone number");
                }

            }
        });
    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    boolean isPhoneValid(CharSequence phone){
        return Patterns.PHONE.matcher(phone).matches();
    }
}
