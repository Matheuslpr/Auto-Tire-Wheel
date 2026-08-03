package dev.matheus.infrastructure.dto.produto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProdutosCreateRequest(
        @NotNull(message = "marcaId é obrigatório")
        Long marcaId,

        @NotBlank(message = "codigo é obrigatório")
        String codigo,

        @NotBlank(message = "nome é obrigatório")
        String nome,

        @Size(max = 500, message = "descricao deve ter no máximo 500 caracteres")
        String descricao,

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
