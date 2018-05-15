package com.aavdeev.capitalandproglang;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CapitalDescriptionFragment extends Fragment {

    private long capitalID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            capitalID = savedInstanceState.getLong("capitalID");
        }
            return inflater.inflate(R.layout.fragment_capital_description, container, false);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("capitalID",capitalID);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Capital capital = Capital.listCapital[(int) capitalID];
            TextView name = view.findViewById(R.id.name_capital);
            name.setText(capital.getName());
            TextView description = view.findViewById(R.id.description_capital);
            description.setText(capital.getDescription());
        }
    }

    public void setCapitalID(long capitalID) {
        this.capitalID = capitalID;
    }
}
