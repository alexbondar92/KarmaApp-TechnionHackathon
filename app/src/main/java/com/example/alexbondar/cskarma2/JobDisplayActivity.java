package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JobDisplayActivity extends AppCompatActivity {

    ListView listv;
    Button north,center,south,all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_display);
        listv = (ListView)findViewById(R.id.listv);
        north = (Button)findViewById(R.id.northbutton);
        center = (Button)findViewById(R.id.centerbutton);
        south = (Button)findViewById(R.id.southbutton);
        all = (Button)findViewById(R.id.allbutton);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CustomAdapter customAdapter = new CustomAdapter(view.getContext(),DataParser.getAllJobs());
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
        });
        north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CustomAdapter customAdapter = new CustomAdapter(view.getContext(),DataParser.getAllJobs()
                .stream().filter(j->j.getRegion().equals("North"))
                        .collect(Collectors.toList()));
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
        });
        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CustomAdapter customAdapter = new CustomAdapter(view.getContext(),DataParser.getAllJobs()
                        .stream().filter(j->j.getRegion().equals("Center"))
                        .collect(Collectors.toList()));
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
        });
        south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Job> southerns = DataParser.getAllJobs()
                        .stream().filter(j->j.getRegion().equals("South")).collect(Collectors.toList());
                final CustomAdapter customAdapter = new CustomAdapter(view.getContext(), southerns);
                listv.setAdapter(customAdapter);
                listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i = new Intent(view.getContext(),JobActivity.class);
                        i.putExtra("ID", southerns.get(position).getId());
                        startActivity(i);
                        finish();
                    }
                });
            }//
        });
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


