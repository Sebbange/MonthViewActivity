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

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

public class FirstActivity extends AppCompatActivity {
    static CalendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        String yearandmonth;
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

        yearandmonth = cal.get(Calendar.YEAR)+"년"+(cal.get(Calendar.MONTH)+1)+"월";
        textView = (TextView)findViewById(R.id.year_first_month);
        textView.setText(yearandmonth);

        cal.set(Calendar.DAY_OF_MONTH, 1);

        ArrayList<CalendarItem> data = new ArrayList<CalendarItem>();
        for(int i=1; i<(cal.getActualMaximum(Calendar.DATE))+1 ;i++) {
            data.add(new CalendarItem(i));
        }

        adapter = new CalendarAdapter(this, R.layout.gridviewcalendar, data);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(FirstActivity.this,yearandmonth+ (position+1)+"일",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}