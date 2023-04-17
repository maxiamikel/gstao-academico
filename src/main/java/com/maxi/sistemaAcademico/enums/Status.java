package com.maxi.sistemaAcademico.enums;

public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    CANCELADO("Cancelado");

    private String status;
    
    private Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
