package com.plataformanext.delta.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.plataformanext.delta.fragments.AulasDinamica;
import com.plataformanext.delta.fragments.AulasEstatica;
import com.plataformanext.delta.fragments.CalculadoraDinamica;
import com.plataformanext.delta.fragments.CalculadoraEstatica;
import com.plataformanext.delta.fragments.DemoDinamica;
import com.plataformanext.delta.fragments.DemoEstatica;


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
        }
        if(position == 1)
        {
            DemoEstatica demo = new DemoEstatica();
            return demo;

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
