package dev.matheus.infrastructure.dto.venda;

import dev.matheus.core.enuns.FormaPagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDateTime;
public record VendasRequest(
        @NotNull(message = "clienteId é obrigatório")
        Long clienteId,

        @NotNull(message = "funcionarioId é obrigatório")
        Long funcionarioId,

        @NotNull(message = "dataVenda é obrigatória")
        LocalDateTime dataVenda,

        @NotNull(message = "formaPagamento é obrigatória")
        FormaPagamento formaPagamento,

        @NotNull(message = "valorTotal é obrigatório")
        @PositiveOrZero(message = "valorTotal não pode ser negativo")
        BigDecimal valorTotal
) {
}
