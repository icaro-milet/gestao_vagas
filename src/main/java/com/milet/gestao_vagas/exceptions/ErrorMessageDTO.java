package com.milet.gestao_vagas.exceptions;

import lombok.Data;

@Data
public class ErrorMessageDTO {

    private String message;
    private String field;

    public ErrorMessageDTO(String message, String field) {
        this.message = message;
        this.field = field;
    }
}
