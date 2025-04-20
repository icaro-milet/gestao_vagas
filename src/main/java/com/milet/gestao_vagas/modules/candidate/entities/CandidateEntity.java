package com.milet.gestao_vagas.modules.candidate.entities;

import lombok.Data;

import jakarta.validation.constraints.Email;
import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;

    @Email
    private String email;
    private String password;
    private String description;
    private String curriculum;
}
