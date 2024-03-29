package com.example.alexbondar.cskarma2;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JobActivity extends AppCompatActivity {

    Organization our_organization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TextView title_name = (TextView)findViewById(R.id.job_title);
        TextView time_and_place = (TextView) findViewById(R.id.job_time_and_place);
        TextView description = (TextView) findViewById(R.id.job_description);
        ImageView pic = (ImageView) findViewById(R.id.job_pic);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long job_id = extras.getLong("ID");
            int value = (int) job_id;


            //The key argument here must match that used in the other activity

            Job current = DataParser.getAJob(value);



            if(current.getImg().equals("Latet")){
                pic.setImageResource(R.drawable.latet_heb);
            }
            if(current.getImg().equals("Ilan")){
                pic.setImageResource(R.drawable.ilan);
            }
            if(current.getImg().equals("Meon Hod")){
                pic.setImageResource(R.drawable.hod);
            }
            if(current.getImg().equals("Leket Yisrael")){
                pic.setImageResource(R.drawable.leket);
            }

            our_organization = DataParser.getOrgByJobId(job_id);
            String str = current.getDate() + ", " + current.getRegion();
            title_name.setText(current.getName());
            time_and_place.setText(str);
            description.setText(current.getDesc());

            Button to_organization = (Button) findViewById(R.id.job_goto_org);
            to_organization.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),OrganizationPage.class);
                    i.putExtra("name", DataParser.getOrgByJobId(current.getId()).getName());
                    startActivity(i);
                }
            });
        }
    }
}
