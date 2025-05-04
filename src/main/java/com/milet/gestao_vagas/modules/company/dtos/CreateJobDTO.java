package com.milet.gestao_vagas.modules.company.dtos;

import lombok.Data;

@Data
public class CreateJobDTO {

    private String description;
    private String level;
    private String benefits;

}
