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
            System.out.println(" "); // 현재 출력 안됨. 매월 1일이 해당하는 요일이 아닐 때마다 공백 출력
        }
        switch(cal.get(Calendar.MONTH)) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                for(int i=1; i<32; i++) {
                    data.add(new CalendarItem(i));
                }
                break;
            case 3:
            case 5:
            case 8:
            case 10:
                for(int i=1; i<31; i++) {
                    data.add(new CalendarItem(i));
                }
                break;
            case 1:
                if(cal.get(Calendar.YEAR)%4==0 && cal.get(Calendar.YEAR)%100!=0 ||
                        cal.get(Calendar.YEAR)%400==0) {
                    for(int i=1; i<29; i++) {
                        data.add(new CalendarItem(i));
                    }
                } else {
                    for(int i=1; i<28; i++) {
                        data.add(new CalendarItem(i));
                    }
                }
                break;
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