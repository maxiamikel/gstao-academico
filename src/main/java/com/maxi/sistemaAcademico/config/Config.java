package com.maxi.sistemaAcademico.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Config {
    

    public static String md5(String senha) throws NoSuchAlgorithmException{
        MessageDigest message = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, message.digest(senha.getBytes()));
        return hash.toString(16);
    }
}
