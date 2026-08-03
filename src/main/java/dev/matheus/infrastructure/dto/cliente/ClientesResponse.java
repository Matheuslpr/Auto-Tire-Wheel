package dev.matheus.infrastructure.dto.cliente;

import dev.matheus.core.enuns.TipoDocumento;

import java.time.LocalDateTime;

public record ClientesResponse(
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
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao


) {
}
