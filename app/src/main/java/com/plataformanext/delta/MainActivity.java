package com.plataformanext.delta;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.plataformanext.delta.adapters.MateriasAdapter;
import com.plataformanext.delta.bluetooth.ListaDispositivos;
import com.plataformanext.delta.domain.Materias;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;

import at.abraxas.amarino.Amarino;
import at.abraxas.amarino.AmarinoIntent;

public class MainActivity extends ActionBarActivity implements RecyclerViewOnClickListenerHack {
    private static final int SOLICITA_ATIVACAO = 1;
    private static final int SOLICITA_CONEXAO = 2;
    private static String MAC = null;
    private BluetoothAdapter mBluetooth = null;
    private StatusAmarino statusAmarino = new StatusAmarino();
    boolean conexao = false;

    private RecyclerView mCardView;
    private FloatingActionMenu fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        fab = (FloatingActionMenu) (findViewById(R.id.fab));

        //CARDS
        mCardView = (RecyclerView) findViewById(R.id.rv_card);
        mCardView.setHasFixedSize(true);
        mCardView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy >0){
                    fab.hideMenuButton(true);
                } else {
                    fab.showMenuButton(true);
                }

                LinearLayoutManager llm = (LinearLayoutManager) mCardView.getLayoutManager();
                MateriasAdapter adapter = (MateriasAdapter) mCardView.getAdapter();
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mCardView.setLayoutManager(llm);

        List<Materias> mList = (this).getSetMateriasList(5);
        MateriasAdapter adapter = new MateriasAdapter(this, mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mCardView.setAdapter(adapter);

        mBluetooth = BluetoothAdapter.getDefaultAdapter();

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

        if (!mBluetooth.isEnabled()) {
            Intent ativa = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(ativa, SOLICITA_ATIVACAO);
        }

        if (mBluetooth.isEnabled()) {
            Intent abreLista = new Intent(MainActivity.this, ListaDispositivos.class);
            startActivityForResult(abreLista, SOLICITA_CONEXAO);
        }
    }

    public void desconectarAxis(View view) {
        if (conexao) {
            Amarino.disconnect(MainActivity.this, MAC);
            unregisterReceiver(statusAmarino);
            conexao = false;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SOLICITA_ATIVACAO:
                if (resultCode == Activity.RESULT_OK) {

                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Bluetooth ativado!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                    Intent abreLista = new Intent(MainActivity.this, ListaDispositivos.class);
                    startActivityForResult(abreLista, SOLICITA_CONEXAO);

                } else {
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Bluetooth não foi ativado!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                break;
            case SOLICITA_CONEXAO:
                if (resultCode == Activity.RESULT_OK) {

                    MAC = data.getExtras().getString(ListaDispositivos.ENDERECO_MAC);

                    registerReceiver(statusAmarino, new IntentFilter(AmarinoIntent.ACTION_CONNECT));

                    Amarino.connect(MainActivity.this, MAC);

                } else {
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Falha ao obter o endereço MAC", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                break;
        }
    }

    protected void onStop() {
        super.onStop();
        if (conexao) {
            Amarino.disconnect(MainActivity.this, MAC);
        }
    }

    public class StatusAmarino extends BroadcastReceiver {

        public double x, y, z;
        public String dados, inicio, X, Y, Z = null;

        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (AmarinoIntent.ACTION_CONNECT.equals(action)) {

                registerReceiver(statusAmarino, new IntentFilter(AmarinoIntent.ACTION_RECEIVED));

                conexao = true;
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Bluetooth conectado!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            } else if (AmarinoIntent.ACTION_CONNECTION_FAILED.equals(action)) {
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Erro durante a conexão!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }

            if(AmarinoIntent.ACTION_RECEIVED.equals(action)){
                final int tipoDados = intent.getIntExtra(AmarinoIntent.EXTRA_DATA_TYPE, -1);

                if (tipoDados == AmarinoIntent.STRING_EXTRA){
                    dados = intent.getStringExtra(AmarinoIntent.EXTRA_DATA);
                    Toast.makeText(MainActivity.this, "Teste: "+dados, Toast.LENGTH_SHORT).show();


                        /*if(dados.equals("s")){
                            inicio = dados;
                        } else if (!inicio.isEmpty() & X.isEmpty()){
                            X = dados;
                            //txtX.setText("Aceleração de X: "+x);
                        } else if (!inicio.isEmpty() & Y.isEmpty()){
                            Y = dados;
                            //txtY.setText("Aceleração de Y: "+dados);
                        } else if (!inicio.isEmpty() & Z.isEmpty()){
                            Z = dados;
                            txtZ.setText("Aceleração de Z: "+dados);
                        } else if (!X.isEmpty()){
                            inicio = "";
                            X = "";
                            Y = "";
                            Z = "";
                        }*/
                }
            }
        }
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