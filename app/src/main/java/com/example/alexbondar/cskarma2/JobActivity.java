package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class JobActivity extends AppCompatActivity {
    int job_id = getIntent().getExtras().getInt("id");

    TextView myAwesomeTextView = (TextView)findViewById(R.id.currentJob);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myAwesomeTextView.setText("My Awesome Text");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
    }
}
