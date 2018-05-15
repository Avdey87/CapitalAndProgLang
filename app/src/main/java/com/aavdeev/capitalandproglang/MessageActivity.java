package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends Activity {

    public static final String MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String msg = (String) getIntent().getExtras().get(MESSAGE);
        TextView textView = findViewById(R.id.activity_message);
        textView.setText(msg);
    }
}
