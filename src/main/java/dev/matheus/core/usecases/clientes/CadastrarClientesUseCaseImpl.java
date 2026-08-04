package dev.matheus.core.usecases.clientes;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;

public class CadastrarClientesUseCaseImpl implements CadastrarClientesUseCase {

    private final ClientesGateway gateway;

    public CadastrarClientesUseCaseImpl(ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Clientes execute(Clientes clientes){
        return gateway.create(clientes);
    }
}
