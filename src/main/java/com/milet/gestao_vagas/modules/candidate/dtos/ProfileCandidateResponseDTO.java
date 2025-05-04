package com.milet.gestao_vagas.modules.candidate.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String description;
}
