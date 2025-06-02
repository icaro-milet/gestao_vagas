package com.milet.gestao_vagas.modules.candidate.dtos;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthCandidateResponseDTO {

    private String access_token;
    private Long expires_in;
}
