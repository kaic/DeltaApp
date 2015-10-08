package com.plataformanext.delta.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.plataformanext.delta.R;
import com.plataformanext.delta.adapters.DemoAdapter;
import com.plataformanext.delta.domain.Demo;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraCinematica extends android.support.v4.app.Fragment  implements RecyclerViewOnClickListenerHack {
    private RecyclerView mCardView;
    private List<Demo> mList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculadora_cinematica, container, false);

        mCardView = (RecyclerView) view.findViewById(R.id.rv_list);
        mCardView.setHasFixedSize(true);
        mCardView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mCardView.getLayoutManager();
                DemoAdapter adapter = (DemoAdapter) mCardView.getAdapter();

            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mCardView.setLayoutManager(llm);

        mList = getSetDemoList(27);
        DemoAdapter adapter = new DemoAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mCardView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClickListener(View view, int position) {
        switch (position){

        }
    }

    public List<Demo> getSetDemoList(int qtd) {
        String[] nome = new String[]{"Conversão de Velocidade", "Velocidade Media", "Equação horária do espaço", "Deslocamento", "Velocidade Relativa", "Aceleração Média", "Função horária da velocidade", "Função horária do espaço", "Equação de Torricelli", "Lançamento Vertical", "Soma de vetores", "Diferença entre vetores", "Produto de um número escalar por um vetor", "Modelo de um vetor", "Produto Escalar", "Ângulo entre dois vetores", "Espaço angular", "Deslocamento Angular", "Velocidade Angular Media", "Aceleração Angular Media", "Converter Frequencia", "Aceleração Centrípeta", "Equação horária do espaço angular", "Aceleração média", "Função horária da velocidade", "Função horária do espaço angular", "Torricelli"};
        String[] conteudo = new String[]{"Velocidade", " Velocidade", "MRU", "MRU", "MRU", "MRUV", "MRUV", "MRUV", "MRUV", "Movimento Vertical", "Vetores", "Vetores", "Vetores", "Vetores", "Vetores", "Vetores", "Movimento Circular", "Movimento Circular", "Movimento Circular", "Movimento Circular", "Movimento Circular", "Movimento Circular Uniforme (MCU)", "Movimento Circular Uniforme (MCU)", "Movimento Circular Uniformemente Variado (MCUV)", "Movimento Circular Uniformemente Variado (MCUV)", "Movimento Circular Uniformemente Variado (MCUV)", "Movimento Circular Uniformemente Variado (MCUV)"};
        String[] axis = new String[]{"", "Axis", "Axis", "Axis", "", "Axis", "Axis", "Axis", "Axis", "?", "", "", "", "", "", "", "?", "?", "?", "?", "?", "?", "?","?", "?", "?", "?"};
        List<Demo> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Demo d = new Demo(nome[i % nome.length], conteudo[i % conteudo.length], axis[i % axis.length]);
            listAux.add(d);
        }
        return (listAux);
    }
}