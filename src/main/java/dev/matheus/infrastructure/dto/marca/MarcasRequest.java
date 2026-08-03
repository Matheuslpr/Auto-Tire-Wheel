package dev.matheus.infrastructure.dto.marca;


import jakarta.validation.constraints.NotBlank;

public record MarcasRequest(
        @NotBlank(message = "nome é obrigatório")
        String nome
) {
}
