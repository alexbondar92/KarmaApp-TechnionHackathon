package com.example.alexbondar.cskarma2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.CalendarContract;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NimrodK on 03/05/2018.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    List<Job> jobs;
    LayoutInflater inflater;
    public CustomAdapter(Context c, List<Job> jobs) {
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
            convertView=inflater.inflate(R.layout.custom_adapter,parent,false);
        }
        Holder hold=new Holder(convertView);
        hold.area.setText(jobs.get(position).getRegion());
        hold.desc.setText(jobs.get(position).getDesc());
        hold.time.setText(jobs.get(position).getTimerange());
        hold.date.setText(jobs.get(position).getDate());
        byte[] decode = Base64.decode(jobs.get(position).getImg(),Base64.DEFAULT);
        Bitmap decoded = BitmapFactory.decodeByteArray(decode,0,decode.length);
        hold.image.setImageBitmap(decoded);
        return convertView;
    }

    private class Holder {
        TextView desc,area,time,date;
        ImageView image;
        Holder(View itemView){
           area=(TextView)itemView.findViewById(R.id.region);
           desc=(TextView)itemView.findViewById(R.id.desc);
           time=(TextView)itemView.findViewById(R.id.timerange);
           date=(TextView)itemView.findViewById(R.id.date);
           image=(ImageView) itemView.findViewById(R.id.imagelogo);
        }
    }
}


