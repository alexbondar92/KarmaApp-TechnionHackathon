package com.example.alexbondar.cskarma2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.exit;

public class Organization {
    private String name;
    private CharSequence desc;
    private URL website;
    private List<Job> jobs;

    public Organization(String name, CharSequence desc, String website_url) {
        this.name = name;
        this.desc = desc;
        this.jobs = new LinkedList<>();
        try {
            this.website = new URL(website_url);
        } catch (MalformedURLException e) {
            exit(1);
        }
    }

    public String getName() {
        return name;
    }

    public CharSequence getDesc() {
        return desc;
    }

    public URL getWebsite() {
        return website;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
