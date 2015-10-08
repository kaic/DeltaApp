package com.plataformanext.delta.adapters;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.plataformanext.delta.fragments.AulasCinematica;
import com.plataformanext.delta.fragments.CalculadoraCinematica;
import com.plataformanext.delta.fragments.DemoCinematica;

public class AbasPagerAdapterCinematica extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    public AbasPagerAdapterCinematica(FragmentManager fm, CharSequence[] titles, int numbOfTabs) {
        super(fm);

        this.Titles = titles;
        this.NumbOfTabs = numbOfTabs;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        if(position == 0)
        {
            AulasCinematica aulas = new AulasCinematica();
            return aulas;
        }
        if(position == 1)
        {
            DemoCinematica demo = new DemoCinematica();
            return demo;

        } else {
            CalculadoraCinematica cal = new CalculadoraCinematica();
            return cal;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}

