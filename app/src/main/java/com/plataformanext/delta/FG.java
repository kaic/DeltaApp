package com.plataformanext.delta;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.plataformanext.delta.adapters.AbasPagerAdapterFG;
import com.plataformanext.delta.extras.SlidingTabLayout;

public class FG extends AppCompatActivity {

    private Toolbar mToolbar;
    ViewPager pager;
    AbasPagerAdapterFG adapter;
    SlidingTabLayout tabs;
    CharSequence titles[]={"AULAS","CALCULADORA"};
    int numbOftabs = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fg);

        mToolbar = (Toolbar) findViewById(R.id.toolbarFG);
        mToolbar.setLogo(R.drawable.delta);
        mToolbar.setTitle("Força Gravitacional");
        setSupportActionBar(mToolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter =  new AbasPagerAdapterFG(getSupportFragmentManager(),titles,numbOftabs);

        pager = (ViewPager) findViewById(R.id.pagerFG);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabsFG);

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
        getMenuInflater().inflate(R.menu.menu_fg, menu);
        return true;
    }

}
