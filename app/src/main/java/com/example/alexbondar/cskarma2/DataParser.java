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

    public static List<Job> getAllJobs() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        List<Job> list = new ArrayList<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> db = (Map<String, Object>) dataSnapshot.getValue();
                Map<String, Object> orgs = (Map<String, Object>) db.get("Organizations");

                for (String i:orgs.keySet()
                     ) {


                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        return null;

    }

    public static List<Organization> getAllOrganization(){
        return null;
    }

}
