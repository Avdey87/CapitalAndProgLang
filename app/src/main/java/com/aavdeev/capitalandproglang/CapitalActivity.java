package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CapitalActivity extends Activity implements CapitalListFragment.CapitalListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);
    }

    @Override
    public void itemClicked(long id) {
        View container = findViewById(R.id.container_capital_description);
        if (container != null) {
            CapitalDescriptionFragment description = new CapitalDescriptionFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            description.setCapitalID(id);
            ft.replace(R.id.container_capital_description, description);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(CapitalActivity.this, CapitalDescriptionActivity.class);
            intent.putExtra(CapitalDescriptionActivity.NAME_CAPITAL, (int) id);
            startActivity(intent);
        }
    }
}
