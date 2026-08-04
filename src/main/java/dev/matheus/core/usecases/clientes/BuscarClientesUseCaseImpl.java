package dev.matheus.core.usecases.clientes;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;

public class BuscarClientesUseCaseImpl implements BuscarClientesUseCase{

    private final ClientesGateway gateway;

    public BuscarClientesUseCaseImpl(ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Clientes execute(Long id){
        var cliente = gateway.findById(id);
        if (cliente == null){
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        return cliente;
    }
}
