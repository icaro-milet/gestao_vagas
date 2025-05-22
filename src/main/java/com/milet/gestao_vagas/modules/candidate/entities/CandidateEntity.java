package com.milet.gestao_vagas.modules.candidate.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import jakarta.validation.constraints.Email;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Nome do candidato",
            example = "Maria Joaquina"
    )
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaço")
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Username do candidato",
            example = "maria.joaquina"
    )
    private String username;

    @Email(message = "O campo [e-mail] deve conter um e-mail válido")
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "E-mail do candidato",
            example = "joaquina@mail.com"
    )
    private String email;

    @Length(min = 1, max = 1000, message = "A senha deve conter entre 1 a 1000 caracteres")
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            minLength = 10,
            maxLength = 100,
            example = "admin123",
            description = "Senha do candidato"
    )
    private String password;

    @Schema(
            example = "Desenvolvedor java",
            description = "Breve descrição do candidato"
    )
    private String description;

    @Schema(example = "Maria Joaquina, 22 anod, nascida em Olinda...")
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
