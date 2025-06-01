package com.milet.gestao_vagas.modules.company.entities;

import com.milet.gestao_vagas.modules.company.entities.CompanyEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "company")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo [name] precisa ser preenchido")
    private String name;

    @NotBlank(message = "O campo [username] precisa ser preenchido")
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaço")
    private String username;

    @Email(message = "O campo [e-mail] deve conter um e-mail válido")
    private String email;

    @Length(min = 1, max = 1000, message = "A senha deve conter entre 1 a 1000 caracteres")
    private String password;

    private String website;

    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
