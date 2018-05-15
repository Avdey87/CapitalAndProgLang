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
            CapitalDescriptionFragment descriptionFragment = new CapitalDescriptionFragment();
            descriptionFragment.setCapitalId(id);

            getFragmentManager().beginTransaction()
                    .replace(R.id.container_capital_description, descriptionFragment)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        } else {
            Intent intent = new Intent(CapitalActivity.this, CapitalDescriptionActivity.class);
            intent.putExtra(CapitalDescriptionActivity.CAPITAL_ID_KEY, (int) id);
            startActivity(intent);
        }
    }
}
