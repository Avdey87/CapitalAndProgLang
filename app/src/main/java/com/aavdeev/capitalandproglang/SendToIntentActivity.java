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
        EditText editText = findViewById(R.id.edit_text);
        String text = editText.getText().toString();
        Intent intent = new Intent(SendToIntentActivity.this, MessageActivity.class);
        intent.putExtra(MessageActivity.MESSAGE, text);
        startActivity(intent);
    }

    public void onClickSendIntent(View view) {
        EditText editText = findViewById(R.id.edit_text);
        String text = editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        Intent cng = Intent.createChooser(intent, "Тип отправки");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(cng);
    }
}
