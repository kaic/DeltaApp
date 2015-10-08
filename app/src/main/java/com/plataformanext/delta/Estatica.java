package com.plataformanext.delta;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.plataformanext.delta.adapters.AbasPagerAdapterDinamica;
import com.plataformanext.delta.adapters.AbasPagerAdapterEstatica;
import com.plataformanext.delta.extras.SlidingTabLayout;

public class Estatica extends AppCompatActivity {

    private Toolbar mToolbar;
    ViewPager pager;
    AbasPagerAdapterEstatica adapter;
    SlidingTabLayout tabs;
    CharSequence titles[]={"AULAS","DEMONSTRAÇÃO","CALCULDORA"};
    int numbOftabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatica);

        mToolbar = (Toolbar) findViewById(R.id.toolbarEstatica);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Estatica");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter =  new AbasPagerAdapterEstatica(getSupportFragmentManager(),titles,numbOftabs);

        pager = (ViewPager) findViewById(R.id.pagerEstatica);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabsEstatica);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.Text);
            }
        });

        tabs.setViewPager(pager);
        pager.setCurrentItem(0);
    }

}
