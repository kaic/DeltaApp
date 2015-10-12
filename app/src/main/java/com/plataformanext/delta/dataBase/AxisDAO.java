package com.plataformanext.delta.dataBase;

import android.content.ContentValues;
import android.content.Context;

import com.plataformanext.delta.domain.Axis;

public class AxisDAO extends DAOBasico<Axis> {

    public static final String NOME_TABELA = "EXERCICIO";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME = "nome";

    public static final String SCRIPT_CRIACAO_TABELA_AXIS = "CREATE TABLE " + NOME_TABELA + "("
            + COLUNA_ID + " INTEGER PRIMARY KEY autoincrement,"
            + COLUNA_NOME + " TEXT,"
            + ")";

    public static final String SCRIPT_DELECAO_TABELA =  "DROP TABLE IF EXISTS " + NOME_TABELA;

    private static AxisDAO instance;

    public static AxisDAO getInstance(Context context) {
        if(instance == null)
            instance = new AxisDAO(context);
        return instance;
    }

    public AxisDAO(Context context) {
        super(context);
    }

    @Override
    public String getNomeTabela() {
        return NOME_TABELA;
    }

    @Override
    public String getNomeColunaPrimaryKey() {
        return COLUNA_ID;
    }

    public ContentValues entidadeParacontentValues(Axis axis) {
        ContentValues values = new ContentValues();
        if(axis.getId() > 0) {
            values.put(COLUNA_ID, axis.getId());
        }
        values.put(COLUNA_NOME, axis.getNome());
        //values.put(COLUNA_ID_ENUNCIADO, axis.getIDEnunciado());

        return values;
    }


    @Override
    public Axis contentValuesParaEntidade(ContentValues contentValues) {
        Axis axis = new Axis();
        axis.setId(contentValues.getAsInteger(COLUNA_ID));
        axis.setNome(contentValues.getAsString(COLUNA_NOME));

        return axis;
    }
}