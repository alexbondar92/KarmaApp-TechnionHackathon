package com.example.alexbondar.cskarma2;

//used to parse data from the database.

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static android.content.ContentValues.TAG;

public class DataParser {

    static DataSnapshot data;

    public static void getData(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                data = dataSnapshot;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
    });
    }


    public static List<Job> getAllJobs() {
        List<Job> list = new ArrayList<>();

        Map<String, Object> db = (Map<String, Object>) data.getValue();
        Map<String, Object> orgs = (Map<String, Object>) db.get("Organizations");

        for (String i : orgs.keySet()
                ) {
            Map<String, Object> o = (Map<String, Object>) orgs.get(i);
            Map<String, Object> jobs = (Map<String, Object>) o.get("jobs");

            list.addAll(parse_jobs(jobs));
        }
        return list;
    }

    public static Job getAJob(int id){
        Boolean f = false;

        List<Job> l = getAllJobs();
        return l.stream().filter(j->j.getId() == id).collect(Collectors.toList()).get(0);
    }

    public static List<Organization> getAllOrganizations(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        List<Organization> list = new ArrayList<>();

        Map<String, Object> db = (Map<String, Object>) data.getValue();
        Map<String, Object> orgs = (Map<String, Object>) db.get("Organizations");

                for (String i:orgs.keySet()) {
                Map<String, Object> o =(Map<String, Object>) orgs.get(i);
                List<Job> jobs = parse_jobs((Map<String, Object>)o.get("jobs"));
                list.add(new Organization(i, (String) o.get("desc"), (String) o.get("website"), (String)o.get("type"), jobs));
            }

            return list;
    }

    public static Organization getOrgByJobId(long id) {
        List<Organization> orgs = getAllOrganizations();
        for (Organization o : orgs) {
            List<Job> cur_jobs = o.getJobs();
            for (Job j : o.getJobs())
                if (j.getId() == id) return o;
        }
        return null;
    }

    private static List<Job> parse_jobs(Map<String, Object> jobs){
        List<Job> list = new ArrayList<>();
        for (String j:jobs.keySet()) {

            Map<String, Object> a_job=(Map<String, Object>) jobs.get(j);
            Job job = new Job(j, (Long)a_job.get("id"), (String)a_job.get("desc"), (String)a_job.get("pic"), (String)a_job.get("region"), (String)a_job.get("type"), (String)a_job.get("date"), (String)a_job.get("time_range"));

            list.add(job);
        }

        return list;
    }

}
