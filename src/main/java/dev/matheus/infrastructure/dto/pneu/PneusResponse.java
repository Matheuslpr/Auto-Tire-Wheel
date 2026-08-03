package dev.matheus.infrastructure.dto.pneu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PneusResponse(
        Long id,
        Long marcaId,
        String codigo,
        String nome,
        Integer larguraMm,
        Integer perfil,
        Integer aro,
        String indiceCarga,
        String indiceVelocidade,
        BigDecimal precoCusto,
        BigDecimal precoVenda,
        Integer estoque,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao
) {
}
