package com.example.alexbondar.cskarma2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class OrganizationPage extends AppCompatActivity {

    TextView name;
    TextView description;
    TextView url;
    ListView jobs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_page);

        name = findViewById(R.id.orgpage_name);
        description = findViewById(R.id.orgpage_desc);
        url = findViewById(R.id.orgpage_website);
        jobs = findViewById(R.id.orgpage_job_list);

        // some kind of black magic to get the organization.
        // assume at end, I know something.

        Bundle extra_info = getIntent().getExtras();
        List<Job> jobs = new LinkedList<>(); //TODO: use the context to get the relevant list.

    }


}
