package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LangDescriptionActivity extends Activity {

    public static final String LANG_DESCRIPTION_KEY = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang_description);

        int descriptionId = getIntent().getIntExtra(LANG_DESCRIPTION_KEY, -1);
        ProgLang language = ProgLang.LANGUAGES[descriptionId];

        ImageView langPhotoView = findViewById(R.id.photo_lang);
        langPhotoView.setImageResource(language.getId());
        langPhotoView.setContentDescription(language.getName());

        TextView nameView = findViewById(R.id.name_lang);
        nameView.setText(language.getName());

        TextView descriptionView = findViewById(R.id.description_lang);
        descriptionView.setText(language.getDescription());
    }
}
