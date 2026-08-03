package dev.matheus.infrastructure.dto.itemVenda;

import dev.matheus.core.enuns.TipoItemVenda;

import java.math.BigDecimal;

public record ItensVendaResponse(
        Long id,
        Long vendaId,
        TipoItemVenda tipoItem,
        Long itemId,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal

) {
}
