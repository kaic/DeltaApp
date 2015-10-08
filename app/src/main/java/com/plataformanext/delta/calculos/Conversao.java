package com.plataformanext.delta.calculos;

import android.os.Bundle;
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
    private Button converterM;
    private EditText km;
    private EditText m;
    private TextView txtKm;
    private TextView txtM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversao);

        mToolbar = (Toolbar) findViewById(R.id.toolbarConversao);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Demonstração");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        converter = (Button) findViewById(R.id.btnKm);
        converterM = (Button) findViewById(R.id.btnM);

        km = (EditText) findViewById(R.id.edtDistancia);
        m = (EditText) findViewById(R.id.edtTempo);

        txtKm = (TextView) findViewById(R.id.txtKm);
        txtM = (TextView) findViewById(R.id.txtM);
    }

    public void conversaoKm (View view) {
        if (km.getText().toString().trim().length() > 0){
            double nKm = parseDouble(km.getText().toString());
            double result = nKm /3.6;
            String resultado = String.valueOf(result);

            txtM.setText(resultado+" M/S");
        } else {
            txtM.setText("Desculpe, não convertemos valores inexistentes!");
        }


    }
    public void conversaoM (View view) {
        if (m.getText().toString().trim().length() > 0){
            double nM = parseDouble(m.getText().toString());
            double result = nM * 3.6;
            String resultado = String.valueOf(result);

            txtKm.setText(resultado+" KM/H");
        } else {
            txtKm.setText("Desculpe, não convertemos valores inexistentes!");
        }
    }
}
