package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LangDescriptionActivity extends Activity {

    public static final String LANG_DESCRIPTION = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang_description);

        int des = (int) getIntent().getExtras().get(LANG_DESCRIPTION);
        ProgLang list = ProgLang.listLang[des];

        ImageView langPhoto = findViewById(R.id.photo_lang);
        langPhoto.setImageResource(list.getId());
        langPhoto.setContentDescription(list.getName());

        TextView name = findViewById(R.id.name_lang);
        name.setText(list.getName());

        TextView description = findViewById(R.id.description_lang);
        description.setText(list.getDescriptoin());
    }
}
