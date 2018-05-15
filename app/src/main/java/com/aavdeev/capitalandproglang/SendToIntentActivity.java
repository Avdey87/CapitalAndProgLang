package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendToIntentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to_intent);
    }

    public void onClickSendToActivity(View view) {
        EditText inputView = findViewById(R.id.text_input);

        String text = inputView.getText().toString();
        Intent intent = new Intent(SendToIntentActivity.this, MessageActivity.class);
        intent.putExtra(MessageActivity.MESSAGE_KEY, text);
        startActivity(intent);
    }

    public void onClickSendIntent(View view) {
        EditText inputView = findViewById(R.id.text_input);

        String text = inputView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        Intent sendIntent = Intent.createChooser(intent, getString(R.string.send_to_type));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(sendIntent);
    }
}
