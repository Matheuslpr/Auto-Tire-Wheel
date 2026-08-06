package dev.matheus.infrastructure.mapper.fornecedor;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.infrastructure.persistence.FornecedoresEntity;
import org.springframework.stereotype.Component;

@Component
public class FornecedoresEntityMapper {

    public FornecedoresEntity toEntity(Fornecedores fornecedores) {
        FornecedoresEntity entity = new FornecedoresEntity();
        entity.setId(fornecedores.id());
        entity.setRazaoSocial(fornecedores.razaoSocial());
        entity.setNomeFantasia(fornecedores.nomeFantasia());
        entity.setTipoDocumento(fornecedores.tipoDocumento());
        entity.setNumeroDocumento(fornecedores.numeroDocumento());
        entity.setInscricaoEstadual(fornecedores.inscricaoEstadual());
        entity.setNomeContato(fornecedores.nomeContato());
        entity.setEmail(fornecedores.email());
        entity.setTelefone(fornecedores.telefone());
        entity.setLogradouro(fornecedores.logradouro());
        entity.setNumero(fornecedores.numero());
        entity.setBairro(fornecedores.bairro());
        entity.setCidade(fornecedores.cidade());
        entity.setEstado(fornecedores.estado());
        entity.setCep(fornecedores.cep());
        entity.setDataCadastro(fornecedores.dataCadastro());
        entity.setDataAtualizacao(fornecedores.dataAtualizacao());

        return entity;
    }

    public Fornecedores toDomain(FornecedoresEntity fornecedores) {
        return new Fornecedores(
                fornecedores.getId(),
                fornecedores.getRazaoSocial(),
                fornecedores.getNomeFantasia(),
                fornecedores.getTipoDocumento(),
                fornecedores.getNumeroDocumento(),
                fornecedores.getInscricaoEstadual(),
                fornecedores.getNomeContato(),
                fornecedores.getEmail(),
                fornecedores.getTelefone(),
                fornecedores.getLogradouro(),
                fornecedores.getNumero(),
                fornecedores.getBairro(),
                fornecedores.getCidade(),
                fornecedores.getEstado(),
                fornecedores.getCep(),
                fornecedores.getDataCadastro(),
                fornecedores.getDataAtualizacao()
        );
    }
}
