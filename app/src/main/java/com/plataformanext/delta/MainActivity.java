package com.plataformanext.delta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.plataformanext.delta.adapters.MateriasAdapter;
import com.plataformanext.delta.aulas.AulaGeral;
import com.plataformanext.delta.domain.Materias;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements RecyclerViewOnClickListenerHack {
    private com.github.clans.fab.FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setLogo(R.drawable.delta);
        mToolbar.setTitle(" Delta");
        setSupportActionBar(mToolbar);

        fab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fabAula);
        //CARDS
        RecyclerView mCardView = (RecyclerView) findViewById(R.id.rv_card);
        mCardView.setHasFixedSize(true);

        mCardView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    fab.hide(true);
                } else {
                    fab.show(true);
                }

            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mCardView.setLayoutManager(llm);

        List<Materias> mList = (this).getSetMateriasList(4);
        MateriasAdapter adapter = new MateriasAdapter(this, mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mCardView.setAdapter(adapter);

    }

    @Override
    public void onClickListener(View view, int position) {
        Intent i;
        switch (position){
            case 0:
                i = new Intent(this, Cinematica.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, Dinamica.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, Estatica.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, FG.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void AulaMecanica(View view) {
        Intent i = new Intent(this, AulaGeral.class);
        startActivity(i);
    }


    public List<Materias> getSetMateriasList(int qtd) {
        String[] materia = new String[]{"Cinemática", "Dinâmica", "Estática e Hidrostática", "Força Gravitacional"};
        String[] subtitulo = new String[]{"Movimento", "Causa dos movimentos", "Equilibrio dos corpos", "Comportamento dos corpos sob ação gravitacional"};
        int[] photos = new int[]{R.drawable.gallardo, R.drawable.vyron, R.drawable.corvette, R.drawable.porsche_911};
        List<Materias> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Materias m = new Materias(materia[i % materia.length], subtitulo[i % subtitulo.length], photos[i % photos.length]);
            listAux.add(m);
        }
        return (listAux);
    }
}