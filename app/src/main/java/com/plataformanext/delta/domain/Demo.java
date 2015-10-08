package com.plataformanext.delta.domain;

public class Demo {
    private String nome;
    private String axis;
    private String conteudo;

    public Demo(){}

    public Demo(String n, String c, String a) {
        nome = n;
        conteudo = c;
        axis = a;

    }


    public String getNome() {
        return nome;
    }

    public String getAxis() {
        return axis;
    }

    public String getConteudo() {
        return conteudo;
    }

}
