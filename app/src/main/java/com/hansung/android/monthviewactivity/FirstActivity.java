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

        int firstday = cal.getActualMinimum(Calendar.DATE); // 매월 첫 번째 날짜(== 1일)
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK); // 요일

        ArrayList<CalendarItem> data = new ArrayList<CalendarItem>();
        if(firstday!=dayofweek) {
             // 현재 출력 안됨. 매월 1일이 해당하는 요일이 아닐 때마다 공백 출력
        }
        for(int i=1; i<(cal.getActualMaximum(Calendar.DATE))+1 ;i++) {
            data.add(new CalendarItem(i));
        } // 매월 1일이 요일과 일치하면 (ex: 22년 4월 1일은 금요일) 그때부터 해당 말일(4월은 30일)까지 날짜 출력

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