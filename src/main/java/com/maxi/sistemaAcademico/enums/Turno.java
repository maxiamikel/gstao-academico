package com.maxi.sistemaAcademico.enums;

public enum Turno {
    MANHA("Manha"),
    TARDE("Tarde"),
    NOITE("Noite");

    private String turno;

    private Turno(String turno){
        this.turno = turno;
    }
}
