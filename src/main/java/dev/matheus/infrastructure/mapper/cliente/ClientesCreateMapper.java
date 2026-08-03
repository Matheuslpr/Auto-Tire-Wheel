package dev.matheus.infrastructure.mapper.cliente;

import dev.matheus.core.entities.Clientes;
import dev.matheus.infrastructure.dto.cliente.ClientesCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClientesCreateMapper {

    public ClientesCreateRequest toDto(Clientes clientes){
        return new ClientesCreateRequest(
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


    public Clientes toEntity(ClientesCreateRequest create){
        return new Clientes(
                null,
                create.nome(),
                create.tipoDocumento(),
                create.numeroDocumento(),
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
