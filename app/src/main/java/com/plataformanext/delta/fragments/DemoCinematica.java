package com.plataformanext.delta.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.plataformanext.delta.R;
import com.plataformanext.delta.adapters.DemoAdapter;
import com.plataformanext.delta.axis.DeviceListActivity;
import com.plataformanext.delta.demo.AcMediaDemo;
import com.plataformanext.delta.demo.ConversaoDemo;
import com.plataformanext.delta.demo.DeslocamentoDemo;
import com.plataformanext.delta.demo.EHEDemo;
import com.plataformanext.delta.demo.FHEDemo;
import com.plataformanext.delta.demo.FHVDemo;
import com.plataformanext.delta.demo.TorriceliDemo;
import com.plataformanext.delta.demo.VelocidadeDemo;
import com.plataformanext.delta.domain.Demo;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;

public class DemoCinematica extends android.support.v4.app.Fragment implements RecyclerViewOnClickListenerHack {
    private com.github.clans.fab.FloatingActionButton fab;
    private RecyclerView mCardDemo;
    private List<Demo> mListDemo;
    public String address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo_cinematica, container, false);

        Intent intent = getActivity().getIntent();
        address = intent.getStringExtra(DeviceListActivity.EXTRA_DEVICE_ADDRESS);

        fab = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.fabCinematica);

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

        mListDemo = getSetDemoList(8);
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
                i = new Intent(getActivity(), ConversaoDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;
            case 1:
                i = new Intent(getActivity(), VelocidadeDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;
            case 2:
                i = new Intent(getActivity(), EHEDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;
            case 3:
                i = new Intent(getActivity(), DeslocamentoDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;
            case 4:
                i = new Intent(getActivity(), AcMediaDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;
            case 5:
                i = new Intent(getActivity(), FHVDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;
            case 6:
                i = new Intent(getActivity(), FHEDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;
            case 7:
                i = new Intent(getActivity(), TorriceliDemo.class);
                i.putExtra("device address", address);
                startActivity(i);
                break;

        }
    }

  public List<Demo> getSetDemoList(int qtd) {
        String[] nome = new String[]{
                "Conversão de Velocidade",
                "Velocidade Média",
                "Equação horária do espaço",
                "Deslocamento",
                "Aceleração Média",
                "Função horária da velocidade",
                "Função horária do espaço",
                "Equação de Torricelli",
        };
        String[] materia = new String[]{
                "Velocidade",
                "Velocidade",
                "MRU",
                "MRU",
                "MRUV",
                "MRUV",
                "MRUV",
                "MRUV",
        };

        List<Demo> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Demo c = new Demo(nome[i % nome.length], materia[i % materia.length]);
            listAux.add(c);
        }
        return (listAux);
    }

}
