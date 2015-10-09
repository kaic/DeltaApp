package com.plataformanext.delta;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.plataformanext.delta.adapters.AbasPagerAdapterCinematica;
import com.plataformanext.delta.extras.SlidingTabLayout;

public class Cinematica extends AppCompatActivity {
    private Toolbar mToolbar;
    ViewPager pager;
    AbasPagerAdapterCinematica adapter;
    SlidingTabLayout tabs;
    CharSequence titles[]={"AULAS","DEMONSTRAÇÃO","CALCULADORA"};
    int numbOftabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinematica);

        mToolbar = (Toolbar) findViewById(R.id.toolbarCinematica);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Cinemática");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter =  new AbasPagerAdapterCinematica(getSupportFragmentManager(),titles,numbOftabs);

        pager = (ViewPager) findViewById(R.id.pagerCinematica);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabsCinematica);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.Text);
            }
        });

        tabs.setViewPager(pager);
        pager.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cinematica, menu);
        return true;
    }

}
