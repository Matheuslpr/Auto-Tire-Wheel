package dev.matheus.core.entities;

import java.time.LocalDateTime;

public record Marcas(
        Long id,
        String nome,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao

) {
}
