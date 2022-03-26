package com.hansung.android.monthviewactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private ArrayList<MyItem> mItems = new ArrayList<MyItem>();

    public MyAdapter(Context context, int resource, ArrayList<MyItem> items) {
        mContext = context;
        mItems = items;
        mResource = resource;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent,false);
        }

//        TextView year = (ImageView) convertView.findViewById(R.id.iconItem);
//        year.setText(mItems.get(position).mYear);
//
//        TextView month = (TextView) convertView.findViewById(R.id.textItem1);
//        month.setText(mItems.get(position).mMonth);
//
//        TextView day = (TextView) convertView.findViewById(R.id.textItem2);
//        day.setText(mItems.get(position).mDay);

        return convertView;
    }
}
