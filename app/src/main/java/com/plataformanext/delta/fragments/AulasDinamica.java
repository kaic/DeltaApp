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
import com.plataformanext.delta.aulas.AulaVelocidade;
import com.plataformanext.delta.aulas.AulaVetores;
import com.plataformanext.delta.domain.Aulas;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;


public class AulasDinamica extends android.support.v4.app.Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<Aulas> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_aulas_dinamica, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_listAD);
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

        mList = getSetAulasList(14);
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
                i = new Intent(getActivity(), AulaVetores.class);
                startActivity(i);
                break;
        }
    }

    public List<Aulas> getSetAulasList(int qtd) {
        String[] nome = new String[]{
                "Dinâmica",
                "Leis de Newton",
                "Força",
                "Atrito",
                "Interação entre blocos em contato",
                "Interação entre blocos e fios",
                "Plano inclinado",
                "Trabalho",
                "Potência",
                "Energia",
                "Impulso",
                "Quantidade de Movimento",
                "Teorema do Impulso",
                "Conservação da Quantidade de Movimento"
        };
        String[] materia = new String[]{
                "Apresentação",
                "1ª, 2ª e 3ª",
                "F. Resultante, de Peso, Tração, Atrito entre outros",
                "Atrito Elástico e Dinâmico",
                "",
                "",
                "Sem e com atrito",
                "Trabalho com força variavel, peso, paralela ou não",
                "Potência Média e Instantânea",
                "Energia Potencial, Cinética e Mecânica",
                "",
                "",
                "",
                ""
        };
        List<Aulas> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Aulas a = new Aulas(nome[i % nome.length], materia[i % materia.length]);
            listAux.add(a);
        }
        return (listAux);
    }

}
