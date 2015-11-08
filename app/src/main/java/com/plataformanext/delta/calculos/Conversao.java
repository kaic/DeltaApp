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

import static java.lang.Double.parseDouble;

public class Conversao extends AppCompatActivity {
    private Toolbar mToolbar;

    private Button converter;
    private EditText km;
    private EditText m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversao);

        mToolbar = (Toolbar) findViewById(R.id.toolbarConversao);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Conversão");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        converter = (Button) findViewById(R.id.converterC);

        km = (EditText) findViewById(R.id.conversaoKm);
        m = (EditText) findViewById(R.id.conversaoM);

    }

    public void conversao (View view) {
        if (km.getText().toString().trim().length() > 0){
            double nKm = parseDouble(km.getText().toString());
            String resultadoKm = String.valueOf(nKm / 3.6);

            km.setText(resultadoKm);
        } else {
            //Snackbar.make(view, "Desculpe, não convertemos valores inexistentes!", Snackbar.LENGTH_SHORT).show();
        }
        if (m.getText().toString().trim().length() > 0){
            double nM = parseDouble(m.getText().toString());
            String resultadoM = String.valueOf(nM * 3.6);

            km.setText(resultadoM);
        } else {
            //Snackbar.make(view, "Desculpe, não convertemos valores inexistentes!", Snackbar.LENGTH_SHORT).show();
        }
    }

}
