package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class JobDisplayActivity extends AppCompatActivity {

    ListView listv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_display);
        listv = (ListView)findViewById(R.id.listv);

        final CustomAdapter customAdapter = new CustomAdapter(this,DataParser.getAllJobs());
        listv.setAdapter(customAdapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(view.getContext(),JobActivity.class);
                i.putExtra("ID", position );
                startActivity(i);
            }
        });


    }

}


