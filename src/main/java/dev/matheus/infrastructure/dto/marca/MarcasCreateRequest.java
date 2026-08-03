package dev.matheus.infrastructure.dto.marca;

import jakarta.validation.constraints.NotBlank;

public record MarcasCreateRequest(
        @NotBlank(message = "O nome da marca é obrigatório")
        String nome
) {
}
