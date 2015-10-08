package com.plataformanext.delta.domain;

public class Materias {
    private String materia;
    private String subtitulo;
    private int photo;

    public Materias(){}
    public Materias(String m, String s, int p){
        materia = m;
        subtitulo = s;
        photo = p;
    }

    public String getMateria() {
        return materia;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public int getPhoto() {
        return photo;
    }

}
