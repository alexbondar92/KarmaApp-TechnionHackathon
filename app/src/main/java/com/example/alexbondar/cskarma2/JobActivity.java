package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class JobActivity extends AppCompatActivity {


//    int job_id = getIntent().getExtras().getInt("id");

//    TextView myAwesomeTextView = (TextView)findViewById(R.id.currentJob);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        TextView title_name = (TextView)findViewById(R.id.currentJob);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("ID");
            //The key argument here must match that used in the other activity

            Job current = DataParser.getAJob(value);
            title_name.setText(current.getName());

        }
    }
}
