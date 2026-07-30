package dev.matheus.core.entities;

import dev.matheus.core.enuns.TipoItemVenda;

import java.math.BigDecimal;

public record ItensVenda(
        Long id,
        Long vendaId,
        TipoItemVenda tipoItem,
        Long itemId,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal

) {
}
