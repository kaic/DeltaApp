package com.plataformanext.delta.calculos;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.plataformanext.delta.R;

public class Conversao extends AppCompatActivity {
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (this.getIntent().getExtras().getInt("parametro")) {
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
                        if (km.getText().toString().trim().length() > 0) {
                            float KM = Float.parseFloat(km.getText().toString());
                            km.setText(String.valueOf(KM / 3.6));
                        }
                    }
                });

                btnM.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (m.getText().toString().trim().length() > 0) {
                            float M = Float.parseFloat(m.getText().toString());
                            m.setText(String.valueOf(M * 3.6));
                        }
                    }
                });

                break;
            case 2:
                setContentView(R.layout.activity_velocidade_media);
                mToolbar = (Toolbar) findViewById(R.id.toolbarConversao);
                setSupportActionBar(mToolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                break;

            case 6:
                setContentView(R.layout.fhe);
                Toolbar mToolbar6 = (Toolbar) findViewById(R.id.toolbarFhe);
                setSupportActionBar(mToolbar6);
                mToolbar6.setTitle("Função horária do espaço");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                final EditText ei = (EditText) findViewById(R.id.FheEI);
                final EditText t = (EditText) findViewById(R.id.FheT);
                final EditText a = (EditText) findViewById(R.id.FheA);
                final EditText vi = (EditText) findViewById(R.id.FheVI);

                final TextView txtFhe = (TextView) findViewById(R.id.txtFhe);
                final Button btnFhe = (Button) findViewById(R.id.btnFhe);



                btnFhe.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (ei.getText().toString().trim().length() > 0
                                & t.getText().toString().trim().length() > 0
                                & a.getText().toString().trim().length() > 0
                                & vi.getText().toString().trim().length() > 0) {

                            final float EI = Float.parseFloat(ei.getText().toString());
                            final float T = Float.parseFloat(t.getText().toString());
                            final float A = Float.parseFloat(a.getText().toString());
                            final float VI = Float.parseFloat(vi.getText().toString());

                            txtFhe.setText(String.valueOf(EI + (VI * T)) + (0.5 * (A * (T * T))) + " Metros");

                        } else {
                            Snackbar snackbar = Snackbar
                                    .make(btnFhe, "Insira todos os valores para realizar o calculo", Snackbar.LENGTH_LONG);

                            snackbar.show();
                        }
                    }
                });
                break;
        }
    }
}
