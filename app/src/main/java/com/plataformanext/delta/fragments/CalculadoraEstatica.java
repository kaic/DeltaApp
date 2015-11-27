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

public class CalculadoraEstatica extends android.support.v4.app.Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<Calculadora> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculadora_estatica, container, false);

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

        mList = getSetCalcList(11);
        CalculadoraAdapter adapter = new CalculadoraAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

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

        }
    }

    public List<Calculadora> getSetCalcList(int qtd) {
        String[] nome = new String[]{"Centro de massa (CM)","Momento de uma força (M)", "Módulo do Momento da Força","Pressão","Densidade","Pressão Hidrostática","Teorema de Stevin","Teorema de Pasca","Prensa Hidráulica","Princípio de Arquimedes","Peso Aparente"};
        String[] conteudo = new String[]{"Estática","Estática","Estática","Hidrostática","Hidrostática","Hidrostática","Hidrostática","Hidrostática","Hidrostática","Empuxo","Empuxo"};
        List<Calculadora> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Calculadora c = new Calculadora(nome[i % nome.length], conteudo[i % conteudo.length]);
            listAux.add(c);
        }
        return (listAux);
    }
}