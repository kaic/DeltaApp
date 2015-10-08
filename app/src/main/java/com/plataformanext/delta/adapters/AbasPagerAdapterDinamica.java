package com.plataformanext.delta.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.plataformanext.delta.fragments.AulasDinamica;
import com.plataformanext.delta.fragments.CalculadoraDinamica;
import com.plataformanext.delta.fragments.DemoDinamica;


public class AbasPagerAdapterDinamica extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumbOfTabs;

    public AbasPagerAdapterDinamica(FragmentManager fm, CharSequence[] titles, int numbOfTabs) {
        super(fm);

        this.Titles = titles;
        this.NumbOfTabs = numbOfTabs;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        if(position == 0)
        {
            AulasDinamica aulas = new AulasDinamica();
            return aulas;
        }
        if(position == 1)
        {
            DemoDinamica demo = new DemoDinamica();
            return demo;

        } else {
            CalculadoraDinamica cal = new CalculadoraDinamica();
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
