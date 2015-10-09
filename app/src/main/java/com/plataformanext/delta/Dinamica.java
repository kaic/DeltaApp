package com.plataformanext.delta;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.plataformanext.delta.adapters.AbasPagerAdapterDinamica;
import com.plataformanext.delta.extras.SlidingTabLayout;

public class Dinamica extends AppCompatActivity {

    private Toolbar mToolbar;
    ViewPager pager;
    AbasPagerAdapterDinamica adapter;
    SlidingTabLayout tabs;
    CharSequence titles[]={"AULAS","DEMONSTRAÇÃO","CALCULADORA"};
    int numbOftabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamica);

        mToolbar = (Toolbar) findViewById(R.id.toolbarDinamica);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Dinâmica");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter =  new AbasPagerAdapterDinamica(getSupportFragmentManager(),titles,numbOftabs);

        pager = (ViewPager) findViewById(R.id.pagerDinamica);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabsDinamica);

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
