package com.hansung.android.monthviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    static CalendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String yearandmonth;
        TextView textView;

        Button btn_b = findViewById(R.id.button_second_back);
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                startActivity(intent);
            }
        });

        Calendar cal = Calendar.getInstance();
        yearandmonth = cal.get(Calendar.YEAR)+"년"+(cal.get(Calendar.MONTH)+2)+"월";
        textView = (TextView)findViewById(R.id.year_second_month);
        textView.setText(yearandmonth);

        ArrayList<CalendarItem> data = new ArrayList<CalendarItem>();
        for(int i=1; i<(cal.getActualMaximum(Calendar.MONTH)+1) ;i++) {
            data.add(new CalendarItem(i));
        }

        adapter = new CalendarAdapter(this, R.layout.gridviewcalendar, data);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(SecondActivity.this,yearandmonth+ (position+1)+"일",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}