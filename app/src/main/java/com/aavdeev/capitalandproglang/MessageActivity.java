package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends Activity {

    public static final String MESSAGE_KEY = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String message = getIntent().getStringExtra(MESSAGE_KEY);
        TextView messageView = findViewById(R.id.activity_message);
        messageView.setText(message);
    }
}
