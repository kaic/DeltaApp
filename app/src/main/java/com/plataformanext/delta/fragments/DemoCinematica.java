package com.plataformanext.delta.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionMenu;
import com.plataformanext.delta.R;
import com.plataformanext.delta.axis.DeviceListActivity;

public class DemoCinematica extends android.support.v4.app.Fragment {
    private FloatingActionMenu fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fab = (FloatingActionMenu) (getActivity().findViewById(R.id.fab));

        return inflater.inflate(R.layout.fragment_demo_cinematica, container, false);
    }

    public void Axis(View view) {
        Intent i = new Intent(getActivity(), DeviceListActivity.class);
        startActivity(i);
    }

    public void desconectarAxis(View view) {
        Snackbar.make(view, "Desconectar Axis", Snackbar.LENGTH_SHORT).show();
    }

}
