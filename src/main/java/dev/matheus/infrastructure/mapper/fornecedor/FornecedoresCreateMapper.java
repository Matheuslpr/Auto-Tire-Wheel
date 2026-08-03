package dev.matheus.infrastructure.mapper.fornecedor;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.infrastructure.dto.fornecedor.FornecedoresCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FornecedoresCreateMapper {
    public FornecedoresCreateRequest toDto(Fornecedores fornecedores) {
        return new FornecedoresCreateRequest(
                fornecedores.razaoSocial(),
                fornecedores.nomeFantasia(),
                fornecedores.tipoDocumento(),
                fornecedores.numeroDocumento(),
                fornecedores.inscricaoEstadual(),
                fornecedores.nomeContato(),
                fornecedores.email(),
                fornecedores.telefone(),
                fornecedores.logradouro(),
                fornecedores.numero(),
                fornecedores.bairro(),
                fornecedores.cidade(),
                fornecedores.estado(),
                fornecedores.cep()
        );
    }

    public Fornecedores toEntity(FornecedoresCreateRequest create) {
        return new Fornecedores(
                null,
                create.razaoSocial(),
                create.nomeFantasia(),
                create.tipoDocumento(),
                create.numeroDocumento(),
                create.inscricaoEstadual(),
                create.nomeContato(),
                create.email(),
                create.telefone(),
                create.logradouro(),
                create.numero(),
                create.bairro(),
                create.cidade(),
                create.estado(),
                create.cep(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
