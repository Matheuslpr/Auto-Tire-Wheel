package dev.matheus.infrastructure.dto.itemVenda;

import dev.matheus.core.enuns.TipoItemVenda;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ItensVendaRequest(
        @NotNull(message = "vendaId é obrigatório")
        Long vendaId,

        @NotNull(message = "tipoItem é obrigatório")
        TipoItemVenda tipoItem,

        @NotNull(message = "itemId é obrigatório")
        Long itemId,

        @NotNull(message = "quantidade é obrigatória")
        @Positive(message = "quantidade deve ser maior que zero")
        Integer quantidade,

        @NotNull(message = "precoUnitario é obrigatório")
        @Positive(message = "precoUnitario deve ser maior que zero")
        BigDecimal precoUnitario,

        @NotNull(message = "subtotal é obrigatório")
        @PositiveOrZero(message = "subtotal não pode ser negativo")
        BigDecimal subtotal
) {
}
