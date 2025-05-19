package com.milet.gestao_vagas.modules.candidate.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "João Pedro")
    private String name;

    @Schema(example = "joao.pedro")
    private String username;

    @Schema(example = "jp@mail.com")
    private String email;

    @Schema(example = "Desenvolvedor Python")
    private String description;
}
