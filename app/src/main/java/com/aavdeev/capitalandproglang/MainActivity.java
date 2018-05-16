package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Class<?> target = classFromPosition(position);
                Intent intent = new Intent(MainActivity.this, target);
                startActivity(intent);
            }
        };

        ListView listView = findViewById(R.id.list_option);
        listView.setOnItemClickListener(itemClickListener);
    }



    private Class<?> classFromPosition(int position) {
        Class<?> clazz;
        switch (position) {
            case 0:
                clazz = CapitalActivity.class;
                break;
            case 1:
                clazz = LangListActivity.class;
                break;
            case 2:
                clazz = TimerActivity.class;
                break;
            case 3:
                clazz = SendToIntentActivity.class;
                break;
            case 4:
                clazz = CarBrandActivity.class;
                break;
            default:
                throw new IllegalArgumentException("position=" + position + " is not supported");
        }
        return clazz;
    }
}
