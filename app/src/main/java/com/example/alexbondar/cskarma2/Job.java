package com.example.alexbondar.cskarma2;

import android.media.Image;

import java.sql.Time;
import java.util.Date;

/**
 * Created by NimrodK on 03/05/2018.
 */
//test
public class Job {
    private String name;
    private int id;
    private String desc;
    private String img;
    private String region;
    private String typeofjob;
    private Date date;
    private String timerange;

    public Job() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTypeofjob() {
        return typeofjob;
    }

    public void setTypeofjob(String typeofjob) {
        this.typeofjob = typeofjob;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimerange() {
        return timerange;
    }

    public void setTimerange(String timerange) {
        this.timerange = timerange;
    }


}
