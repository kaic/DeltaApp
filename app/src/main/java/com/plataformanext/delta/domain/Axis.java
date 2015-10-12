package com.plataformanext.delta.domain;

import com.plataformanext.delta.interfaces.EntidadePersistivel;

public class Axis implements EntidadePersistivel {
    private int id;
    private String nome;

    public Axis() {
        super();
        this.id = id;
        this.nome = nome;

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String Enunciado){
        this.nome = nome;
    }
}
