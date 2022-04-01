package com.hansung.android.monthviewactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarAdapter extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private ArrayList<CalendarItem> mItems = new ArrayList<CalendarItem>();

    public CalendarAdapter(Context context, int resource, ArrayList<CalendarItem> items) {
        mContext = context;
        mItems = items;
        mResource = resource;
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String date;
        TextView textView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent,false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.gridview_cal_tv);
        name.setText(mItems.get(position).nDay);

        return convertView;
    }

}
