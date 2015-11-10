package com.plataformanext.delta.demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.plataformanext.delta.R;

public class VelocidadeDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_velocidade);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarDemoVelocidade);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Velocidade Média");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    }

}
