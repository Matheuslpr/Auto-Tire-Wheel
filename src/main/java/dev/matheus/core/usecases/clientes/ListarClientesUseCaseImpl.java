package dev.matheus.core.usecases.clientes;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;

import java.util.List;

public class ListarClientesUseCaseImpl implements ListarClientesUseCase {

    private final ClientesGateway gateway;

    public ListarClientesUseCaseImpl(ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Clientes> execute() {
        return gateway.findAll();
    }
}
