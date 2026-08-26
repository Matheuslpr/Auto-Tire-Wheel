package dev.matheus.core.usecases.clientes;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

import java.time.LocalDateTime;

public class AtualizarClientesUseCaseImpl implements AtualizarClientesUseCase{

    private final ClientesGateway gateway;

    public AtualizarClientesUseCaseImpl(ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Clientes execute(Clientes clientes){
        var existente = gateway.findById(clientes.id());
        if(existente == null){
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        return gateway.replace( new Clientes(
                existente.id(),
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
                    existente.dataCadastro(),
                    LocalDateTime.now())
        );
    }

}
