package com.example.alexbondar.cskarma2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.exit;

public class Organization {
    private String name;
    private String desc;
    private String website;
    private List<Job> jobs;
    private String type;

    public Organization(String name, String desc, String website_url, String type) {
        this.name = name;
        this.desc = desc;
        this.jobs = new LinkedList<>();
        this.website = website_url;
    }

    public String getName() {
        return name;
    }

    public CharSequence getDesc() {
        return desc;
    }

    public String getWebsite() {
        return website;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
