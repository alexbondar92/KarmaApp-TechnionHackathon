package com.example.alexbondar.cskarma2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.stream.Collectors;

public class OrgDisplayPage extends AppCompatActivity {
    ListView listvv;
    Button manage,addev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_display_page);

        listvv=(ListView)findViewById(R.id.listorgdis);
        List<Job> southerns = DataParser.getAllJobs()
                .stream().filter(j->j.getImg().equals("Latet")).collect(Collectors.toList());
        final CustomAdapter customAdapter = new CustomAdapter(this, southerns);
        listvv.setAdapter(customAdapter);
    }
}
