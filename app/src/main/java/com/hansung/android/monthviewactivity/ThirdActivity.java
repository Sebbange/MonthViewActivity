package com.hansung.android.monthviewactivity;

import static java.util.Calendar.MONTH;

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

public class ThirdActivity extends AppCompatActivity {
    static CalendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        String yearandmonth;
        TextView textView;

        Button btn_t_n = findViewById(R.id.button_third_next);
        btn_t_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                startActivity(intent);
            }
        });

        Calendar cal = Calendar.getInstance();
        yearandmonth = cal.get(Calendar.YEAR)+"년"+(cal.get(Calendar.MONTH))+"월";
        textView = (TextView)findViewById(R.id.year_third_month);
        textView.setText(yearandmonth);

        ArrayList<CalendarItem> data = new ArrayList<CalendarItem>();

        cal.set(cal.get(Calendar.YEAR), MONTH-1, 32);
        int startday = cal.get(Calendar.DAY_OF_WEEK);
        if(startday != 1) {
            for(int i=0; i<startday-4; i++) {
                data.add(new CalendarItem(" "));
            }
        }
        for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            data.add(new CalendarItem("" + (i + 1)));
        }

        for(int i=1; i<(cal.getActualMaximum(Calendar.DATE))+1 ;i++) {
            data.add(new CalendarItem(i));
        }

        adapter = new CalendarAdapter(this, R.layout.gridviewcalendar, data);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(ThirdActivity.this,yearandmonth+ (position-1)+"일",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}