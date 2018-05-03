package com.example.alexbondar.cskarma2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.alexbondar.cskarma2.Job;

public class OrganizationPage extends AppCompatActivity {

    TextView name;
    TextView description;
    TextView url;
    TextView nameAgain;
    ListView jobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_page);

        name = findViewById(R.id.orgpage_name);
        description = findViewById(R.id.orgpage_desc);
        url = findViewById(R.id.orgpage_website);
        nameAgain = findViewById(R.id.orgpage_joblist_title_orgname);
        jobs = findViewById(R.id.orgpage_job_list);

        // some kind of black magic to get the organization.
        // assume at end, I know something.

        String this_name = getIntent().getStringExtra("name");

        Organization this_org = DataParser.getAllOrganization()
                .stream()
                .distinct()
                .filter(o1 -> (o1.getName().equals(this_name)))
                .collect(Collectors.toList())
                .get(0);
        List<Job> these_jobs = this_org.getJobs();

        name.setText(this_org.getName());
        description.setText(this_org.getDesc());

        String full_url = this_org.getWebsite();
        if (!full_url.startsWith("http://") && !full_url.startsWith("https://"))
            full_url = "http://" + full_url;

        final String actual_url = full_url;
        url.setText(full_url);
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_browser = new Intent(Intent.ACTION_VIEW, Uri.parse(actual_url));
                startActivity(open_browser);
                finish();
            }
        });
        nameAgain.setText(this_org.getName());

        jobs.setAdapter(new CustomAdapter(this,DataParser.getAllJobs()));
        jobs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(),JobActivity.class);
                i.putExtra("ID", position );
                startActivity(i);
            }
        });
    }


}
