package com.maxi.sistemaAcademico.exceptions;

public class EmailExisteException extends Exception {

    public EmailExisteException(String msg) {
        super(msg);
    }

    private static final Long serialVersionUID = 1L;
    
}
