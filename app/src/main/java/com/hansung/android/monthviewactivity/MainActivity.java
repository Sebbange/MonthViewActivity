package com.hansung.android.monthviewactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button back = findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

        Button next = findViewById(R.id.button_next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

        String[] items = {"item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8"};

        ArrayAdapter<String> adapt
                = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapt);
    }
}