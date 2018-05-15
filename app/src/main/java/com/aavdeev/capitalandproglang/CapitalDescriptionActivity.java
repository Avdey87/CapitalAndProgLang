package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;

public class CapitalDescriptionActivity extends Activity {

    public static final String CAPITAL_ID_KEY = "capitalID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_description);

        int capitalID = getIntent().getIntExtra(CAPITAL_ID_KEY, -1);
        CapitalDescriptionFragment descriptionFragment = (CapitalDescriptionFragment)
                getFragmentManager().findFragmentById(R.id.activity_capital_description);
        descriptionFragment.setCapitalId(capitalID);
    }
}
