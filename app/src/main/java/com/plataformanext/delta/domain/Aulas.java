package com.plataformanext.delta.domain;

public class Aulas {
    private String nome;
    private String materia;

    public Aulas(){}
    public Aulas(String n, String m){
        nome = n;
        materia = m;
    }


    public String getNome() {
        return nome;
    }

    public String getMateria() {
        return materia;
    }

}
