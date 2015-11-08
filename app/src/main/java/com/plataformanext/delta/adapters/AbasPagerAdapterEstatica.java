package com.plataformanext.delta.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.plataformanext.delta.fragments.AulasEstatica;
import com.plataformanext.delta.fragments.CalculadoraEstatica;


public class AbasPagerAdapterEstatica extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumbOfTabs;

    public AbasPagerAdapterEstatica(FragmentManager fm, CharSequence[] titles, int numbOfTabs) {
        super(fm);

        this.Titles = titles;
        this.NumbOfTabs = numbOfTabs;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        if(position == 0)
        {
            AulasEstatica aulas = new AulasEstatica();
            return aulas;
        } else {
            CalculadoraEstatica cal = new CalculadoraEstatica();
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
