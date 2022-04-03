package com.hansung.android.monthviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class ThirdActivity extends AppCompatActivity {

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

    }
}