package com.example.learn.lyy.androidui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.learn.lyy.androidui.calendar.CalendarActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置ListView
        lv_main = (ListView) findViewById(R.id.lv_main);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        arrayAdapter.add("calendarlibrary");
        lv_main.setAdapter(arrayAdapter);
        lv_main.setOnItemClickListener(this);
    }


    //lv_main的item点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);

        }
    }
}
