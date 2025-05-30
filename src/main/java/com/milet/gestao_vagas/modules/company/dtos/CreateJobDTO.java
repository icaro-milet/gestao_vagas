package com.milet.gestao_vagas.modules.company.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobDTO {

    @Schema(
            example = "Vaga para pessoa desenvolvedora júnior",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String description;

    @Schema(
            example = "Júnior",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String level;

    @Schema(
            example = "Plano de saúde, gympass",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String benefits;

}
