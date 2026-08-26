package dev.matheus.core.usecases.clientes;


import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;

public class DeletarClientesUseCaseImpl implements DeletarClientesUseCase {

    private final ClientesGateway gateway;

    public DeletarClientesUseCaseImpl(ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Clientes execute(Long id) {
        return gateway.delete(id);
    }
}

