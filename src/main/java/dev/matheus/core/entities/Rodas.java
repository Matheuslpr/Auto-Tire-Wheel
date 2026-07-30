package dev.matheus.core.entities;

import dev.matheus.core.enuns.MaterialRoda;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Rodas(
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
