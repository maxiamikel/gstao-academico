package com.maxi.sistemaAcademico.enums;

public enum Curso {
    ADMINISTRACAO("Administracao"),
    INFORMATICA("Informatica"),
    CONTABILIDADE("Contabilidade"),
    MEDICINA("Medicina");

    private String curso;

    private Curso(String curso){
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }
}
