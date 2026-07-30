package dev.matheus.core.entities;

import dev.matheus.core.enuns.FormaPagamento;
import dev.matheus.core.enuns.StatusVenda;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Vendas(
        Long id,
        Long clienteId,
        Long funcionarioId,
        LocalDateTime dataVenda,
        FormaPagamento formaPagamento,
        BigDecimal valorTotal,
        StatusVenda status,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao

) {
}
