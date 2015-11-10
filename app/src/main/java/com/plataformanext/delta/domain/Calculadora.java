package com.plataformanext.delta.domain;

public class Calculadora {
    private String nome;
    private String conteudo;

    public Calculadora(){}

    public Calculadora(String n, String c) {
        nome = n;
        conteudo = c;

    }

    public String getNome() {
        return nome;
    }

    public String getConteudo() {
        return conteudo;
    }

}
