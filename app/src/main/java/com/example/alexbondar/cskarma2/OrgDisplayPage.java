package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrgDisplayPage extends AppCompatActivity {
    ListView listvv;
    Button manage,addev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_display_page);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        listvv=(ListView)findViewById(R.id.listorgdis);
        List<Job> latet = new ArrayList<>();
        latet.add(new Job("test",1,"test","test","test","test","test","test"));
        final CustomAdapterOrg customAdapter = new CustomAdapterOrg(this, latet);
        listvv.setAdapter(customAdapter);
        listvv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(view.getContext(),UserLoginActivity.class);
                startActivity(i);
            }
        });
    }
}
