package com.example.alexbondar.cskarma2;

//used to parse data from the database.

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class DataParser {

    private boolean flag;

    public static List<Job> getAllJobs() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        final List<Job> list = new ArrayList<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> db = (Map<String, Object>) dataSnapshot.getValue();
                Map<String, Object> orgs = (Map<String, Object>) db.get("Organizations");

                for (String i:orgs.keySet()
                     ) {
                    Map<String, Object> o =(Map<String, Object>) db.get(i);
                    Map<String, Object> jobs = (Map<String, Object>) o.get("jobs");

                    for (String j:jobs.keySet()) {

                        Map<String, String> a_job=(Map<String, String>) jobs.get(j);
                        list.add(new Job(j, Integer.parseInt(a_job.get("id")), a_job.get("desc"), a_job.get("pic"), a_job.get("region"), a_job.get("region"), a_job.get("data"), a_job.get("time_range"), a_job.get("type")));
                        }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }


        });
        return list;

    }

    public static List<Organization> getAllOrganization(){
        return null;
    }

}
