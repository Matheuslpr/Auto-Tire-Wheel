package dev.matheus.infrastructure.mapper.cliente;

import dev.matheus.core.entities.Clientes;
import dev.matheus.infrastructure.dto.cliente.ClientesRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClientesUpdateMapper {

    public ClientesRequest toDto(Clientes clientes) {
        return new ClientesRequest(
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
                clientes.cep()
        );
    }

    public Clientes merge(Clientes clientesExistente, ClientesRequest request){
        return new Clientes(
                clientesExistente.id(),
                request.nome() != null ? request.nome() : clientesExistente.nome(),
                request.tipoDocumento() != null ? request.tipoDocumento() : clientesExistente.tipoDocumento(),
                request.numeroDocumento() != null ? request.numeroDocumento() : clientesExistente.numeroDocumento(),
                request.email() != null ? request.email() : clientesExistente.email(),
                request.telefone() != null ? request.telefone() : clientesExistente.telefone(),
                request.logradouro() != null ? request.logradouro() : clientesExistente.logradouro(),
                request.numero() != null ? request.numero() : clientesExistente.numero(),
                request.bairro() != null ? request.bairro() : clientesExistente.bairro(),
                request.cidade() != null ? request.cidade() : clientesExistente.cidade(),
                request.estado() != null ? request.estado() : clientesExistente.estado(),
                request.cep() != null ? request.cep() : clientesExistente.cep(),
                clientesExistente.dataCadastro(),
                LocalDateTime.now()
        );
    }

    public Clientes toEntity(ClientesRequest clientesRequest){
        return new Clientes(
                null,
                clientesRequest.nome(),
                clientesRequest.tipoDocumento(),
                clientesRequest.numeroDocumento(),
                clientesRequest.email(),
                clientesRequest.telefone(),
                clientesRequest.logradouro(),
                clientesRequest.numero(),
                clientesRequest.bairro(),
                clientesRequest.cidade(),
                clientesRequest.estado(),
                clientesRequest.cep(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
