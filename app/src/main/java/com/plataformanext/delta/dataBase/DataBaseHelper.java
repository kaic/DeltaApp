package com.plataformanext.delta.dataBase;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final String NOME_BANCO_DADOS = "APEIRON";
    private static final int VERSAO_BANCO_DADOS = 1;

    private static DataBaseHelper instance;

    public static DataBaseHelper getInstance(Context context) {
        if(instance == null)
            instance = new DataBaseHelper(context);

        return instance;
    }

    public DataBaseHelper(Context context) {
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AxisDAO.SCRIPT_CRIACAO_TABELA_AXIS);
        Log.i("DATABASE", "CRIANDO TABELA");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("DATABASE", "ATUALIZANDO TABELA");
        db.execSQL(AxisDAO.SCRIPT_DELECAO_TABELA);
        onCreate(db);
    }

}
