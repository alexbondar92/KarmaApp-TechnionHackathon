package com.example.alexbondar.cskarma2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrganizationPage extends AppCompatActivity {

    TextView name;
    TextView description;
    TextView url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_page);

        name = findViewById(R.id.orgpage_name);
        name.setText(R.string.org_name);
    }


}
