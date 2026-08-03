package dev.matheus.infrastructure.dto.roda;

import dev.matheus.core.enuns.MaterialRoda;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record RodasCreateRequest(
        @NotNull(message = "marcaId é obrigatório")
        Long marcaId,

        @NotBlank(message = "codigo é obrigatório")
        String codigo,

        @NotBlank(message = "nome é obrigatório")
        String nome,

        @NotNull(message = "aro é obrigatório")
        @Positive(message = "aro deve ser maior que zero")
        Integer aro,

        @NotNull(message = "larguraPolegadas é obrigatória")
        @Positive(message = "larguraPolegadas deve ser maior que zero")
        BigDecimal larguraPolegadas,

        @NotNull(message = "furos é obrigatório")
        @Positive(message = "furos deve ser maior que zero")
        Integer furos,

        @NotNull(message = "diametroFuracaoMm é obrigatório")
        @Positive(message = "diametroFuracaoMm deve ser maior que zero")
        BigDecimal diametroFuracaoMm,

        @NotNull(message = "offsetEtMm é obrigatório")
        Integer offsetEtMm,

        @NotNull(message = "material é obrigatório")
        MaterialRoda material,

        @NotBlank(message = "corAcabamento é obrigatório")
        String corAcabamento,

        @NotNull(message = "precoCusto é obrigatório")
        @PositiveOrZero(message = "precoCusto não pode ser negativo")
        BigDecimal precoCusto,

        @NotNull(message = "precoVenda é obrigatório")
        @Positive(message = "precoVenda deve ser maior que zero")
        BigDecimal precoVenda,

        @NotNull(message = "estoque é obrigatório")
        @PositiveOrZero(message = "estoque não pode ser negativo")
        Integer estoque
) {
}
