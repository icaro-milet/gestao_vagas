package com.milet.gestao_vagas.exceptions;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException() {
        super("Company not found");
    }
}