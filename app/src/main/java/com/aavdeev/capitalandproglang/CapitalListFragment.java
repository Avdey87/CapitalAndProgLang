package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CapitalListFragment extends ListFragment {

    interface CapitalListListener {
        void itemClicked(long id);
    }

    @Nullable
    private CapitalListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Capital.CAPITALS.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Capital.CAPITALS[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, names);

        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {
            listener = (CapitalListListener) context;
        } catch (ClassCastException cce) {
            throw new RuntimeException("Host should implement "
                    + CapitalListListener.class.getSimpleName(), cce);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
