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
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, CapitalActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, LangListActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, Timer.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, SendToIntentActivity.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, CarBrandActivity.class);
                    startActivity(intent);
                }
            }
        };

        ListView listView = findViewById(R.id.list_option);
        listView.setOnItemClickListener(itemClickListener);
    }
}
