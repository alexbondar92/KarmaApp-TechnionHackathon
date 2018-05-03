package com.example.alexbondar.cskarma2;

import java.sql.Time;
import java.util.Date;

public class Job {
    private Organization organization;
    private Date date;
    private Time time;

    public Job (Organization org, Date date, Time time) {
        this.date = date;
        this.time = time;
        this.organization = org;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }
}
