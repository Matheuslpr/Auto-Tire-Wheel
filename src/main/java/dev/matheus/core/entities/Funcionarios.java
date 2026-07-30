package dev.matheus.core.entities;

import dev.matheus.core.enuns.TipoDocumento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Funcionarios(
        Long id,
        String nome,
        TipoDocumento tipoDocumento,
        String numeroDocumento,
        String email,
        String telefone,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String cargo,
        BigDecimal salario,
        LocalDateTime dataAdmissao,
        LocalDateTime dataDesligamento
) {
}
