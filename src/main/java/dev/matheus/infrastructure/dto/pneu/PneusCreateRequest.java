package dev.matheus.infrastructure.dto.pneu;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record PneusCreateRequest(

        @NotNull(message = "marcaId é obrigatório")
        Long marcaId,

        @NotBlank(message = "codigo é obrigatório")
        String codigo,

        @NotBlank(message = "nome é obrigatório")
        String nome,

        @NotNull(message = "larguraMm é obrigatória")
        @Positive(message = "larguraMm deve ser maior que zero")
        Integer larguraMm,

        @NotNull(message = "perfil é obrigatório")
        @Positive(message = "perfil deve ser maior que zero")
        Integer perfil,

        @NotNull(message = "aro é obrigatório")
        @Positive(message = "aro deve ser maior que zero")
        Integer aro,

        @NotBlank(message = "indiceCarga é obrigatório")
        String indiceCarga,

        @NotBlank(message = "indiceVelocidade é obrigatório")
        String indiceVelocidade,

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
