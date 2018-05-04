package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class JobActivity extends AppCompatActivity {


//    int job_id = getIntent().getExtras().getInt("id");

//    TextView myAwesomeTextView = (TextView)findViewById(R.id.currentJob);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView title_name = (TextView)findViewById(R.id.currentJob);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("ID");
            //The key argument here must match that used in the other activity
            Job current = DataParser.getAJob(Integer.parseInt(value));
            title_name.setText(current.getName());

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
    }

    /*public void goToAttend(View view) {
        TextView pop_preferences = (TextView)findViewById(R.id.preferences);
        pop_preferences.setVisibility(View.VISIBLE);
    }*/
}
