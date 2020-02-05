package com.example.tap_android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AttendanceSchoolAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> uids,name;
    TextView nametv;

    public AttendanceSchoolAdapter(Activity context,ArrayList<String> uids,ArrayList<String> name){
        super(context,R.layout.list_attendance_school, name);
        this.context=context;
        this.name=name;
        this.uids=uids;

    }
    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
         view= inflater.inflate(R.layout.list_attendance_school, null, true);
        nametv=view.findViewById(R.id.TextView);
        nametv.setText(name.get(pos));
        return view;
    }
}
