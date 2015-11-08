package com.plataformanext.delta;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.plataformanext.delta.adapters.AbasPagerAdapterHidrostatica;
import com.plataformanext.delta.extras.SlidingTabLayout;

public class Hidrostatica extends AppCompatActivity {

    private Toolbar mToolbar;
    ViewPager pager;
    AbasPagerAdapterHidrostatica adapter;
    SlidingTabLayout tabs;
    CharSequence titles[]={"AULAS","CALCULADORA"};
    int numbOftabs = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidrostatica);

        mToolbar = (Toolbar) findViewById(R.id.toolbarHidrostatica);
        mToolbar.setLogo(R.drawable.delta);
        mToolbar.setTitle("Hidrostatica");
        setSupportActionBar(mToolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter =  new AbasPagerAdapterHidrostatica(getSupportFragmentManager(),titles,numbOftabs);

        pager = (ViewPager) findViewById(R.id.pagerHidrostatica);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabsHidrostatica);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.Text);
            }
        });

        tabs.setDistributeEvenly(true);
        tabs.setViewPager(pager);
        pager.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hidrostatica, menu);
        return true;
    }
}
