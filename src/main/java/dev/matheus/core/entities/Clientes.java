package dev.matheus.core.entities;

import dev.matheus.core.enuns.TipoDocumento;

import java.time.LocalDateTime;

public record Clientes(
        Long id,
        String nome,
        TipoDocumento documento,
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
