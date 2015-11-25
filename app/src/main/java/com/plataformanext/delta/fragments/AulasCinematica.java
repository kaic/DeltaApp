package com.plataformanext.delta.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.plataformanext.delta.R;
import com.plataformanext.delta.adapters.AulasAdapter;
import com.plataformanext.delta.aulas.AulaAceleracao;
import com.plataformanext.delta.aulas.AulaVelocidade;
import com.plataformanext.delta.aulas.AulaVetores;
import com.plataformanext.delta.domain.Aulas;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;


public class AulasCinematica extends android.support.v4.app.Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<Aulas> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_aulas_cinematica, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_listAC);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                AulasAdapter adapter = (AulasAdapter) mRecyclerView.getAdapter();

            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mList = getSetAulasList(3);
        AulasAdapter adapter = new AulasAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;

    }

    @Override
    public void onClickListener(View view, int position) {
        Intent i;
        switch (position){
            case 0:
                i = new Intent(getActivity(), AulaVelocidade.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(getActivity(), AulaAceleracao.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(getActivity(), AulaVetores.class);
                startActivity(i);
                break;
        }
    }

    public List<Aulas> getSetAulasList(int qtd) {
        String[] nome = new String[]{"Velocidade", "Aceleração", "Vetores"};
        String[] materia = new String[]{"Velocidade normal, escalar, vetorial, angular e relativa", "Aceleração", "Vetores e Operações"};
        List<Aulas> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Aulas a = new Aulas(nome[i % nome.length], materia[i % materia.length]);
            listAux.add(a);
        }
        return (listAux);
    }

}
