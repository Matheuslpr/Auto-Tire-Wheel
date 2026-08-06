package dev.matheus.infrastructure.mapper.cliente;

import dev.matheus.core.entities.Clientes;
import dev.matheus.infrastructure.persistence.ClientesEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientesEntityMapper {

    public ClientesEntity toEntity(Clientes clientes) {
        ClientesEntity entity = new ClientesEntity();

        entity.setId(clientes.id());
        entity.setNome(clientes.nome());
        entity.setTipoDocumento(clientes.tipoDocumento());
        entity.setNumeroDocumento(clientes.numeroDocumento());
        entity.setEmail(clientes.email());
        entity.setTelefone(clientes.telefone());
        entity.setLogradouro(clientes.logradouro());
        entity.setNumero(clientes.numero());
        entity.setBairro(clientes.bairro());
        entity.setCidade(clientes.cidade());
        entity.setEstado(clientes.estado());
        entity.setCep(clientes.cep());
        entity.setDataCadastro(clientes.dataCadastro());
        entity.setDataAtualizacao(clientes.dataAtualizacao());

        return entity;
    }

    public Clientes toDomain(ClientesEntity clientes) {
        return new Clientes(
                clientes.getId(),
                clientes.getNome(),
                clientes.getTipoDocumento(),
                clientes.getNumeroDocumento(),
                clientes.getEmail(),
                clientes.getTelefone(),
                clientes.getLogradouro(),
                clientes.getNumero(),
                clientes.getBairro(),
                clientes.getCidade(),
                clientes.getEstado(),
                clientes.getCep(),
                clientes.getDataCadastro(),
                clientes.getDataAtualizacao()
        );
    }
}
