package com.example.alexbondar.cskarma2;

//used to parse data from the database.

import java.util.List;

public interface DataParser {

    public List<Job> getAllJobs();

    public List<Organization> getAllOrganizations();
}
