package com.plataformanext.delta.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionMenu;
import com.plataformanext.delta.R;
import com.plataformanext.delta.adapters.DemoAdapter;
import com.plataformanext.delta.calculos.Conversao;
import com.plataformanext.delta.calculos.VelocidadeMedia;
import com.plataformanext.delta.domain.Demo;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;

public class DemoDinamica extends android.support.v4.app.Fragment implements RecyclerViewOnClickListenerHack {
    private com.github.clans.fab.FloatingActionButton fab;
    private RecyclerView mCardDemo;
    private List<Demo> mListDemo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo_dinamica, container, false);

        fab = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.fabDinamica);

        mCardDemo = (RecyclerView) view.findViewById(R.id.rv_cardDemo);
        mCardDemo.setHasFixedSize(true);

        mCardDemo.setOnScrollListener(new RecyclerView.OnScrollListener() {
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

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mCardDemo.setLayoutManager(llm);

        mListDemo = getSetDemoList(15);
        DemoAdapter adapter = new DemoAdapter(getActivity(), mListDemo);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mCardDemo.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClickListener(View view, int position) {
        Intent i;
        switch (position){
            case 0:
                i = new Intent(getActivity(), Conversao.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(getActivity(), VelocidadeMedia.class);
                startActivity(i);
                break;

        }
    }

    public List<Demo> getSetDemoList(int qtd) {
        String[] nome = new String[]{
                "2ª Lei de Newton",
                "Força peso",
                "Força resultante",
                "Plano inclinado",
                "Trabalho resultante",
                "Força paralela ao deslocamento",
                "Trabalho da força Peso",
                "Potência média",
                "Potência Instantânea",
                "Energia Cinética",
                "Teorema da Energia Cinética",
                "Energia Potencial Gravitacional",
                "Energia Mecânica",
                "Teorema do Impulso",
                "Quantidade de Movimento",
        };
        String[] materia = new String[]{
                "Força",
                "Força",
                "Força",
                "",
                "Trabalho",
                "Trabalho",
                "Trabalho",
                "Potência",
                "Potência",
                "Energia",
                "Energia",
                "Energia Potencial",
                "",
                "Impulso",
                "",
        };
        List<Demo> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Demo c = new Demo(nome[i % nome.length], materia[i % materia.length]);
            listAux.add(c);
        }
        return (listAux);
    }


}
