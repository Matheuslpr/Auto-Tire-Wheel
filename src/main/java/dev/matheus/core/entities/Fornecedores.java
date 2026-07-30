package dev.matheus.core.entities;

import dev.matheus.core.enuns.TipoDocumento;

import java.time.LocalDateTime;

public record Fornecedores(
        Long id,
        String razaoSocial,
        String nomeFantasia,
        TipoDocumento tipoDocumento,
        String numeroDocumento,
        String inscricaoEstadual,
        String nomeContato,
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
