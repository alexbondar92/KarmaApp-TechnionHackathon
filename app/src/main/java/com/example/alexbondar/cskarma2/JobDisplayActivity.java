package com.example.alexbondar.cskarma2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class JobDisplayActivity extends AppCompatActivity {

    ListView listv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_display);
        listv = (ListView)findViewById(R.id.listv);

        //CustomAdapter customAdapter = new CustomAdapter(this,DataParser.getAllJobs());
        //listv.setAdapter(customAdapter);

    }

}


