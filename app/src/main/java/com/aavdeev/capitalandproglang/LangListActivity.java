package com.aavdeev.capitalandproglang;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LangListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<ProgLang> list = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ProgLang.LANGUAGES);

        ListView listView = getListView();
        listView.setAdapter(list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(LangListActivity.this, LangDescriptionActivity.class);
        intent.putExtra(LangDescriptionActivity.LANG_DESCRIPTION_KEY, (int) id);
        startActivity(intent);
    }
}
