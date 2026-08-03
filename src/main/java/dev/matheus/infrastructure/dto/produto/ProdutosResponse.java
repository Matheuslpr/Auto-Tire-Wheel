package dev.matheus.infrastructure.dto.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutosResponse(
        Long id,
        Long marcaId,
        String codigo,
        String nome,
        String descricao,
        BigDecimal precoCusto,
        BigDecimal precoVenda,
        Integer estoque,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao
) {
}
