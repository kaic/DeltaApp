package com.plataformanext.delta.adapters;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.plataformanext.delta.fragments.AulasCinematica;
import com.plataformanext.delta.fragments.AulasFG;
import com.plataformanext.delta.fragments.CalculadoraCinematica;
import com.plataformanext.delta.fragments.CalculadoraFG;
import com.plataformanext.delta.fragments.DemoCinematica;
import com.plataformanext.delta.fragments.DemoFG;

public class AbasPagerAdapterFG extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    public AbasPagerAdapterFG(FragmentManager fm, CharSequence[] titles, int numbOfTabs) {
        super(fm);

        this.Titles = titles;
        this.NumbOfTabs = numbOfTabs;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        if(position == 0)
        {
            AulasFG aulas = new AulasFG();
            return aulas;
        }
        if(position == 1)
        {
            DemoFG demo = new DemoFG();
            return demo;

        } else {
            CalculadoraFG cal = new CalculadoraFG();
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

