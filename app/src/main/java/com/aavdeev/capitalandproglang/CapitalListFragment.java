package com.aavdeev.capitalandproglang;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class CapitalListFragment extends ListFragment {

interface CapitalListListener{
    void itemClicked(long id);
}

    private CapitalListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Capital.listCapital.length];
        for (int i = 0; i<names.length; i++) {
            names[i] = Capital.listCapital[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, names);

        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        listener = (CapitalListListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }

    }
}
