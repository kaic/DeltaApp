package com.plataformanext.delta.fragments;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.plataformanext.delta.R;
import com.plataformanext.delta.adapters.DemoAdapter;
import com.plataformanext.delta.demo.AcMediaDemo;
import com.plataformanext.delta.demo.ConversaoDemo;
import com.plataformanext.delta.demo.DeslocamentoDemo;
import com.plataformanext.delta.demo.FHEDemo;
import com.plataformanext.delta.demo.FHVDemo;
import com.plataformanext.delta.domain.Demo;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DemoCinematica extends android.support.v4.app.Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mCardDemo;
    private List<Demo> mListDemo;
    private BluetoothAdapter mBtAdapter;
    private ArrayAdapter<String> mPairedDevicesArrayAdapter;
    public String address;
    private Button btnConectar;
    private  ListView pairedListView;
    public static String EXTRA_DEVICE_ADDRESS = "device_address";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo_cinematica, container, false);


        pairedListView = (ListView) view.findViewById(R.id.paired_devicesCinematica);
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

            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mCardDemo.setLayoutManager(llm);

        mListDemo = getSetDemoList(5);
        DemoAdapter adapter = new DemoAdapter(getActivity(), mListDemo);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mCardDemo.setAdapter(adapter);

        btnConectar = (Button) view.findViewById(R.id.btnAxisCinematica);
        btnConectar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkBTState();
                mPairedDevicesArrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.device_name);
                pairedListView.setAdapter(mPairedDevicesArrayAdapter);
                pairedListView.setOnItemClickListener(mDeviceClickListener);

                mBtAdapter = BluetoothAdapter.getDefaultAdapter();

                Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();

                if (pairedDevices.size() > 0) {
                    for (BluetoothDevice device : pairedDevices) {
                        mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                    }
                } else {
                    String noDevices = getResources().getText(R.string.none_paired).toString();
                    mPairedDevicesArrayAdapter.add(noDevices);
                }
                btnConectar.setVisibility(View.INVISIBLE);
                pairedListView.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private AdapterView.OnItemClickListener mDeviceClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {

            String info = ((TextView) v).getText().toString();
            address = info.substring(info.length() - 17);
            pairedListView.setVisibility(View.INVISIBLE);
            mCardDemo.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public void onClickListener(View view, int position) {
        Intent i;
        switch (position){
            case 0:
                i = new Intent(getActivity(), ConversaoDemo.class);
                i.putExtra(EXTRA_DEVICE_ADDRESS, address);
                startActivity(i);
                break;
            case 1:
                i = new Intent(getActivity(), DeslocamentoDemo.class);
                i.putExtra(EXTRA_DEVICE_ADDRESS, address);
                startActivity(i);
                break;
            case 2:
                i = new Intent(getActivity(), AcMediaDemo.class);
                i.putExtra(EXTRA_DEVICE_ADDRESS, address);
                startActivity(i);
                break;
            case 3:
                i = new Intent(getActivity(), FHVDemo.class);
                i.putExtra(EXTRA_DEVICE_ADDRESS, address);
                startActivity(i);
                break;
            case 4:
                i = new Intent(getActivity(), FHEDemo.class);
                i.putExtra(EXTRA_DEVICE_ADDRESS, address);
                startActivity(i);
                break;

        }
    }

  public List<Demo> getSetDemoList(int qtd) {
        String[] nome = new String[]{
                "Velocidade",
                "Equação horária do espaço/Deslocamento",
                "Aceleração Média",
                "Função horária da velocidade",
                "Função horária do espaço",
        };
        String[] materia = new String[]{
                "Velocidade",
                "MRU",
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

    private void checkBTState() {
        mBtAdapter= BluetoothAdapter.getDefaultAdapter();

        if(mBtAdapter != null) {
            if (mBtAdapter.isEnabled()) {
            } else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        } else {
            Toast.makeText(getActivity(), "Dispositivo não suporta bluetooth", Toast.LENGTH_SHORT).show();
        }
    }

}
