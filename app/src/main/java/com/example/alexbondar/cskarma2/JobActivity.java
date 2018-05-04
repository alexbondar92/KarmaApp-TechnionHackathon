package com.example.alexbondar.cskarma2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JobActivity extends AppCompatActivity {


//    int job_id = getIntent().getExtras().getInt("id");

//    TextView myAwesomeTextView = (TextView)findViewById(R.id.currentJob);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        TextView title_name = (TextView)findViewById(R.id.job_title);
        TextView time_and_place = (TextView) findViewById(R.id.job_time_and_place);
        TextView description = (TextView) findViewById(R.id.job_description);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = (int) extras.getLong("ID");
            //The key argument here must match that used in the other activity

            Job current = DataParser.getAJob(value);
            String str = current.getDate() + ", " + current.getRegion();
            title_name.setText(current.getName());
            time_and_place.setText(str);
            description.setText(current.getDesc());
        }
    }
}
