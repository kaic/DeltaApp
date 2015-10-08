package com.plataformanext.delta.calculos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.plataformanext.delta.R;

import static java.lang.Double.parseDouble;

public class VelocidadeMedia extends AppCompatActivity {
    private Toolbar mToolbar;
    private EditText distancia, tempo, resultado;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidade_media);

        mToolbar = (Toolbar) findViewById(R.id.toolbarMedia);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Velocidade Média");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        distancia = (EditText) findViewById(R.id.edtDistancia);
        resultado = (EditText) findViewById(R.id.edtResultado);
        tempo = (EditText) findViewById(R.id.edtTempo);

        result = (TextView) findViewById(R.id.txtResultado);


    }

    public void velocidade (View view) {
        if (distancia.getText().toString().trim().length() > 0){
            double dist = parseDouble(distancia.getText().toString());
            double temp = parseDouble(tempo.getText().toString());
            double velocidade = dist/temp;

            String vel = String.valueOf(velocidade);

            result.setText(vel + " KM/H");

        } else {
            result.setText("Desculpe, não convertemos valores inexistentes!");
        }
    }
}
