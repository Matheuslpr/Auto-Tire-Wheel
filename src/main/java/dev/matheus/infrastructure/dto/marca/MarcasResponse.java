package dev.matheus.infrastructure.dto.marca;

import java.time.LocalDateTime;

public record MarcasResponse(
        Long id,
        String nome,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao

) {
}
