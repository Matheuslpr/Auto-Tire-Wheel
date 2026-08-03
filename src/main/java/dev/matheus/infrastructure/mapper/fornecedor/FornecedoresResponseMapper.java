package dev.matheus.infrastructure.mapper.fornecedor;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.infrastructure.dto.fornecedor.FornecedoresResponse;
import org.springframework.stereotype.Component;

@Component
public class FornecedoresResponseMapper {

    public FornecedoresResponse toDto(Fornecedores fornecedores) {
        return new FornecedoresResponse(
                fornecedores.id(),
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
                fornecedores.cep(),
                fornecedores.dataCadastro(),
                fornecedores.dataAtualizacao()
        );
    }

    public static Fornecedores toEntity(FornecedoresResponse response) {
        return new Fornecedores(
                response.id(),
                response.razaoSocial(),
                response.nomeFantasia(),
                response.tipoDocumento(),
                response.numeroDocumento(),
                response.inscricaoEstadual(),
                response.nomeContato(),
                response.email(),
                response.telefone(),
                response.logradouro(),
                response.numero(),
                response.bairro(),
                response.cidade(),
                response.estado(),
                response.cep(),
                response.dataCadastro(),
                response.dataAtualizacao()
        );
    }
}
