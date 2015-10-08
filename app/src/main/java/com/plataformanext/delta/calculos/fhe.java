package com.plataformanext.delta.calculos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.charts.LineChart;
import com.plataformanext.delta.R;

public class fhe extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fhe);

        mToolbar = (Toolbar) findViewById(R.id.toolbarFhe);
        mToolbar.setTitle("Função horaria do espaço");
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LineChart chart = (LineChart) findViewById(R.id.chart);
    }

}
