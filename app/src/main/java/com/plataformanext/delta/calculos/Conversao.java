package com.plataformanext.delta.calculos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                final EditText km = (EditText) findViewById(R.id.conversaoKm);
                final EditText m = (EditText) findViewById(R.id.conversaoM);
                Button btnKM = (Button) findViewById(R.id.cKM);
                Button btnM = (Button) findViewById(R.id.cM);

                btnKM.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (km.getText().toString().trim().length() > 0){
                            float KM = Float.parseFloat(km.getText().toString());
                            km.setText(String.valueOf(KM / 3.6));
                        }
                    }
                });

                btnM.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (m.getText().toString().trim().length() > 0){
                            float M = Float.parseFloat(m.getText().toString());
                            m.setText(String.valueOf(M * 3.6));
                        }
                    }
                });

                break;
            case 2:
                setContentView(R.layout.activity_velocidade_media);
                mToolbar = (Toolbar) findViewById(R.id.toolbarMedia);
                setSupportActionBar(mToolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                break;
        }

    }
}
