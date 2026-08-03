package dev.matheus.infrastructure.mapper.cliente;

import dev.matheus.core.entities.Clientes;
import dev.matheus.infrastructure.dto.cliente.ClientesResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientesResponseMapper {

    public ClientesResponse toDto(Clientes clientes) {
       return new ClientesResponse(
               clientes.id(),
               clientes.nome(),
               clientes.tipoDocumento(),
               clientes.numeroDocumento(),
               clientes.email(),
               clientes.telefone(),
               clientes.logradouro(),
               clientes.numero(),
               clientes.bairro(),
               clientes.cidade(),
               clientes.estado(),
               clientes.cep(),
               clientes.dataCadastro(),
               clientes.dataAtualizacao()
       );
    }

    public static Clientes toEntity(ClientesResponse response) {
        return new Clientes(
                response.id(),
                response.nome(),
                response.tipoDocumento(),
                response.numeroDocumento(),
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
