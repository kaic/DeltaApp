package com.plataformanext.delta.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.plataformanext.delta.R;
import com.plataformanext.delta.adapters.CalculadoraAdapter;
import com.plataformanext.delta.calculos.Conversao;
import com.plataformanext.delta.domain.Calculadora;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraCinematica extends android.support.v4.app.Fragment  implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<Calculadora> mList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculadora_cinematica, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mList = getSetCalcList(14);
        CalculadoraAdapter adapter = new CalculadoraAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClickListener(View view, int position) {
        Intent i;
        int parametro;
        switch (position){
            case 0:
                i = new Intent(getActivity(), Conversao.class);
                parametro = 1;
                i.putExtra("parametro", parametro);
                startActivity(i);
                break;
            case 1:
                i = new Intent(getActivity(), Conversao.class);
                parametro = 2;
                i.putExtra("parametro", parametro);
                startActivity(i);
                break;

            case 6:
                i = new Intent(getActivity(), Conversao.class);
                parametro = 6;
                i.putExtra("parametro", parametro);
                startActivity(i);
                break;

        }
    }

    public List<Calculadora> getSetCalcList(int qtd) {
        String[] nome = new String[]{
                "Conversão de Velocidade",
                "Velocidade Media",
                "Equação horária do espaço",
                "Deslocamento",
                "Aceleração Média",
                "Função horária da velocidade",
                "Função horária do espaço",
                "Equação de Torricelli",
                "Espaço angular/Deslocamento Angular",
                "Velocidade Angular Media",
                "Aceleração Centrípeta",
                "Função horária da velocidade",
                "Função horária do espaço angular"
        };

        String[] conteudo = new String[]{
                "Velocidade",
                "Velocidade",
                "MRU",
                "MRU",
                "MRUV",
                "MRUV",
                "MRUV",
                "MRUV",
                "Movimento Circular",
                "Movimento Circular",
                "Movimento Circular Uniforme (MCU)",
                "Movimento Circular Uniformemente Variado (MCUV)",
                "Movimento Circular Uniformemente Variado (MCUV)"
        };
        List<Calculadora> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Calculadora c = new Calculadora(nome[i % nome.length], conteudo[i % conteudo.length]);
            listAux.add(c);
        }
        return (listAux);
    }
}