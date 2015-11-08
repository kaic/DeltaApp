package com.plataformanext.delta.domain;

/**
 * Created by kaic on 05/11/15.
 */
public class Demo  {
    private String nome;
    private String materia;

        public Demo(){}
        public Demo(String n, String m){
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
