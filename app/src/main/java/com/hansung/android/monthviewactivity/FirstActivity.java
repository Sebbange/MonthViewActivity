package com.hansung.android.monthviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

public class FirstActivity extends AppCompatActivity {
    static CalendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        String date;
        int day;
        TextView textView;

        Button btn_n = findViewById(R.id.button_first_next);
        btn_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btn_b = findViewById(R.id.button_first_back);
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

        Calendar cal = Calendar.getInstance();

        date = cal.get(Calendar.YEAR)+"년"+(cal.get(Calendar.MONTH)+1)+"월";
        textView = (TextView)findViewById(R.id.year_first_month);
        textView.setText(date);

        ArrayList<CalendarItem> data = new ArrayList<CalendarItem>();
        data.add(new CalendarItem("1"));
        data.add(new CalendarItem("2"));
        data.add(new CalendarItem("3"));
        data.add(new CalendarItem("4"));
        data.add(new CalendarItem("5"));
        data.add(new CalendarItem("6"));
        data.add(new CalendarItem("7"));
        data.add(new CalendarItem("8"));
        data.add(new CalendarItem("9"));
        data.add(new CalendarItem("10"));
        data.add(new CalendarItem("11"));
        data.add(new CalendarItem("12"));
        data.add(new CalendarItem("13"));
        data.add(new CalendarItem("14"));
        data.add(new CalendarItem("15"));
        data.add(new CalendarItem("16"));
        data.add(new CalendarItem("17"));
        data.add(new CalendarItem("18"));
        data.add(new CalendarItem("19"));
        data.add(new CalendarItem("20"));
        data.add(new CalendarItem("21"));
        data.add(new CalendarItem("22"));
        data.add(new CalendarItem("23"));
        data.add(new CalendarItem("24"));
        data.add(new CalendarItem("25"));
        data.add(new CalendarItem("26"));
        data.add(new CalendarItem("27"));
        data.add(new CalendarItem("28"));
        data.add(new CalendarItem("29"));
        data.add(new CalendarItem("30"));
        data.add(new CalendarItem("31"));

        adapter = new CalendarAdapter(this, R.layout.gridviewcalendar, data);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(FirstActivity.this,date+ (position+1)+"일",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}