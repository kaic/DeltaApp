package com.plataformanext.delta.bluetooth;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Set;


public class ListaDispositivos extends ListActivity {

    private BluetoothAdapter mBluetooth;
    public static String ENDERECO_MAC = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> ArrayBluetooth = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        mBluetooth = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> dispositivosPareados = mBluetooth.getBondedDevices();

        if(dispositivosPareados.size() > 0){
            for (BluetoothDevice dispositivo : dispositivosPareados){
                String nome = dispositivo.getName();
                String mac = dispositivo.getAddress();
                ArrayBluetooth.add(nome + "\n" +mac);

            }
        }
        setListAdapter(ArrayBluetooth);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String infoGeral = ((TextView)v).getText().toString();
        String endereco = infoGeral.substring(infoGeral.length() - 17);

        Intent retornaMac = new Intent();
        retornaMac.putExtra(ENDERECO_MAC, endereco);

        setResult(RESULT_OK, retornaMac);
        finish();
    }
}
