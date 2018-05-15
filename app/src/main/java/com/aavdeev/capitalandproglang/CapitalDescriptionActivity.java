package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;

public class CapitalDescriptionActivity extends Activity {

    public static final String NAME_CAPITAL = "capitalID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_description);

        int capitalID = (int) getIntent().getExtras().get(NAME_CAPITAL);
        CapitalDescriptionFragment descriptoin = (CapitalDescriptionFragment) getFragmentManager().findFragmentById(R.id.activity_capital_description);
        descriptoin.setCapitalID(capitalID);
    }
}
