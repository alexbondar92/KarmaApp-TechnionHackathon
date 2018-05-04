package com.example.alexbondar.cskarma2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NimrodK on 03/05/2018.
 */

public class CustomAdapterOrg extends BaseAdapter {

    Context c;
    List<Job> jobs;
    LayoutInflater inflater;
    public CustomAdapterOrg(Context c, List<Job> jobs) {
        this.c = c;
        this.jobs = jobs;
    }



    @Override
    public int getCount() {
        return jobs.size();
    }

    @Override
    public Object getItem(int position) {
        return jobs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater==null){
            inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null){
            convertView=inflater.inflate(R.layout.custom_org_adapter,parent,false);
        }
        return convertView;
    }

}


