package com.plataformanext.delta.domain;

public class Axis  {
    private int id;
    private String Data;
    private float aceleracao;

    public Axis() {
        super();
        this.id = id;
        this.Data = Data;
        this.aceleracao = aceleracao;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public float getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(float aceleracao) {
        this.aceleracao = aceleracao;
    }

}
