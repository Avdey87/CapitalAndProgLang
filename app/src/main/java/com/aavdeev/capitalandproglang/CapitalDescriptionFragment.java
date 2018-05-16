package com.aavdeev.capitalandproglang;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CapitalDescriptionFragment extends Fragment {

    private static final String CAPITAL_ID_KEY = "CAPITAL_ID";

    @SuppressWarnings("FieldCanBeLocal")
    private TextView nameView;
    @SuppressWarnings("FieldCanBeLocal")
    private TextView descriptionView;

    private long capitalId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_capital_description, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameView = view.findViewById(R.id.name_capital);
        descriptionView = view.findViewById(R.id.description_capital);

        if (savedInstanceState != null) {
            capitalId = savedInstanceState.getLong(CAPITAL_ID_KEY);
        }

        // do all init
        Capital capital = Capital.CAPITALS[(int) capitalId];
        nameView.setText(capital.getName());
        descriptionView.setText(capital.getDescription());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(CAPITAL_ID_KEY, capitalId);
    }

    public void setCapitalId(long capitalId) {
        this.capitalId = capitalId;
    }
}
