package com.milet.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("usuário existente");
    }
}
