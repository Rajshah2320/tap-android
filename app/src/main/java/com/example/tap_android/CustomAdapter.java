package com.example.tap_android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String>uids,name;
    TextView nametv;

    public CustomAdapter(Activity context,ArrayList<String> uids,ArrayList<String> name){
        super(context, R.layout.list1, name);
        this.context=context;
        this.name=name;
        this.uids=uids;

    }
    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.list1, null, true);
        nametv=row.findViewById(R.id.TextView);
        nametv.setText(name.get(pos));
        return row;
    }
}
