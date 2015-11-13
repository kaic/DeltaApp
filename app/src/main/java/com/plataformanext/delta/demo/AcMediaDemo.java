package com.plataformanext.delta.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.plataformanext.delta.R;

public class AcMediaDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_acmedia);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarDemoAcMedia);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Aceleração Média");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    }

}
