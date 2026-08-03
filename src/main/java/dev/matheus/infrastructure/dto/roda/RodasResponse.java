package dev.matheus.infrastructure.dto.roda;

import dev.matheus.core.enuns.MaterialRoda;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RodasResponse(
        Long id,
        Long marcaId,
        String codigo,
        String nome,
        Integer aro,
        BigDecimal larguraPolegadas,
        Integer furos,
        BigDecimal diametroFuracaoMm,
        Integer offsetEtMm,
        MaterialRoda material,
        String corAcabamento,
        BigDecimal precoCusto,
        BigDecimal precoVenda,
        Integer estoque,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao


) {
}
