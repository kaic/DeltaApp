package com.plataformanext.delta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.github.clans.fab.FloatingActionMenu;
import com.plataformanext.delta.adapters.MateriasAdapter;
import com.plataformanext.delta.domain.Materias;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements RecyclerViewOnClickListenerHack {
    private FloatingActionMenu fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        fab = (FloatingActionMenu) (findViewById(R.id.fab));

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
                    fab.hideMenuButton(true);
                } else {
                    fab.showMenuButton(true);
                }

            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mCardView.setLayoutManager(llm);

        List<Materias> mList = (this).getSetMateriasList(5);
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
                i = new Intent(this, Hidrostatica.class);
                startActivity(i);
                break;
            case 4:
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


    public void Axis(View view) {
        Snackbar.make(view, "Conectar Axis", Snackbar.LENGTH_SHORT).show();
    }

    public void desconectarAxis(View view) {
        Snackbar.make(view, "Desconectar Axis", Snackbar.LENGTH_SHORT).show();
    }


    public List<Materias> getSetMateriasList(int qtd) {
        String[] materia = new String[]{"Cinemática", "Dinâmica", "Estatica", "Hidrostatica", "Força Gravitacional"};
        String[] subtitulo = new String[]{"Movimento", "Causa dos movimentos", "Equilibrio dos corpos", "Equilibrio dos corpos imersos na agua", "Comportamento dos corpos sob ação gravitacional"};
        int[] photos = new int[]{R.drawable.gallardo, R.drawable.vyron, R.drawable.corvette, R.drawable.paganni_zonda, R.drawable.porsche_911};
        List<Materias> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Materias m = new Materias(materia[i % materia.length], subtitulo[i % subtitulo.length], photos[i % photos.length]);
            listAux.add(m);
        }
        return (listAux);
    }
}