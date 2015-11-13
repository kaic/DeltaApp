package com.plataformanext.delta.calculos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.plataformanext.delta.R;

public class Conversao extends AppCompatActivity {
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (this.getIntent().getExtras().getInt("parametro")){
            case 1:
                setContentView(R.layout.activity_conversao);
                mToolbar = (Toolbar) findViewById(R.id.toolbarConversao);
                setSupportActionBar(mToolbar);
                mToolbar.setTitle("Conversão");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                break;
            case 2:
                setContentView(R.layout.activity_velocidade_media);
                mToolbar = (Toolbar) findViewById(R.id.toolbarMedia);
                setSupportActionBar(mToolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                break;
        }

    }

    public void calculo (View view) {
    }

}
