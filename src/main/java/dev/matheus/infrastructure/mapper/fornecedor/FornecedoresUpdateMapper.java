package dev.matheus.infrastructure.mapper.fornecedor;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.infrastructure.dto.fornecedor.FornecedoresRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FornecedoresUpdateMapper {

    public FornecedoresRequest toDto(Fornecedores fornecedores) {
        return new FornecedoresRequest(
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

    public Fornecedores merge(Fornecedores fornecedoresExistente, FornecedoresRequest request){
        return new Fornecedores(
                fornecedoresExistente.id(),
                request.razaoSocial() != null ? request.razaoSocial() : fornecedoresExistente.razaoSocial(),
                request.nomeFantasia() != null ? request.nomeFantasia() : fornecedoresExistente.nomeFantasia(),
                request.tipoDocumento() != null ? request.tipoDocumento() : fornecedoresExistente.tipoDocumento(),
                request.numeroDocumento() != null ? request.numeroDocumento() : fornecedoresExistente.numeroDocumento(),
                request.inscricaoEstadual() != null ? request.inscricaoEstadual() : fornecedoresExistente.inscricaoEstadual(),
                request.nomeContato() != null ? request.nomeContato() : fornecedoresExistente.nomeContato(),
                request.email() != null ? request.email() : fornecedoresExistente.email(),
                request.telefone() != null ? request.telefone() : fornecedoresExistente.telefone(),
                request.logradouro() != null ? request.logradouro() : fornecedoresExistente.logradouro(),
                request.numero() != null ? request.numero() : fornecedoresExistente.numero(),
                request.bairro() != null ? request.bairro() : fornecedoresExistente.bairro(),
                request.cidade() != null ? request.cidade() : fornecedoresExistente.cidade(),
                request.estado() != null ? request.estado() : fornecedoresExistente.estado(),
                request.cep() != null ? request.cep() : fornecedoresExistente.cep(),
                fornecedoresExistente.dataCadastro(),
                LocalDateTime.now()
        );
    }

    public Fornecedores toEntity(FornecedoresRequest request){
        return new Fornecedores(
                null,
                request.razaoSocial(),
                request.nomeFantasia(),
                request.tipoDocumento(),
                request.numeroDocumento(),
                request.inscricaoEstadual(),
                request.nomeContato(),
                request.email(),
                request.telefone(),
                request.logradouro(),
                request.numero(),
                request.bairro(),
                request.cidade(),
                request.estado(),
                request.cep(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
