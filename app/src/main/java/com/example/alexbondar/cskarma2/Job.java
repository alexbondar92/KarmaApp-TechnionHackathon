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
    private long id;
    private String desc;
    private String img;
    private String region;
    private String date;
    private String timerange;
    private String type;

    public Job(String name, long id, String desc, String img, String region, String type, String date, String timerange) {
        this.name = name;
        this.id = id;
        this.desc = desc;
        this.img = img;
        this.region = region;
        this.timerange = timerange;
        this.type = type;
        this.date = date;
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

    public void setType(String type) { this.type = type;}

    public String getType(String type) {return this.type;}

    public long getId() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimerange() {
        return timerange;
    }

    public void setTimerange(String timerange) {
        this.timerange = timerange;
    }


}
