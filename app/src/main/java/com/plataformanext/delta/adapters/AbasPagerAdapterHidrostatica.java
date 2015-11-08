package com.plataformanext.delta.adapters;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.plataformanext.delta.fragments.AulasHidrostatica;
import com.plataformanext.delta.fragments.CalculadoraHidrostatica;

public class AbasPagerAdapterHidrostatica extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    public AbasPagerAdapterHidrostatica(FragmentManager fm, CharSequence[] titles, int numbOfTabs) {
        super(fm);

        this.Titles = titles;
        this.NumbOfTabs = numbOfTabs;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        if(position == 0)
        {
            AulasHidrostatica aulas = new AulasHidrostatica();
            return aulas;
        } else {
            CalculadoraHidrostatica cal = new CalculadoraHidrostatica();
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

