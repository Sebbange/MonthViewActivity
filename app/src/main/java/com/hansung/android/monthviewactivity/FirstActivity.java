package com.hansung.android.monthviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        String date;
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

    }
}