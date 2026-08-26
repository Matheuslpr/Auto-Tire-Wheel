package dev.matheus.core.usecases.clientes;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;
import dev.matheus.infrastructure.exception.DuplicateException;

public class CadastrarClientesUseCaseImpl implements CadastrarClientesUseCase {

    private final ClientesGateway gateway;

    public CadastrarClientesUseCaseImpl(ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Clientes execute(Clientes clientes){
        if (gateway.existsByNumeroDocumento(clientes.numeroDocumento())) {
            throw new DuplicateException("Já existe um cliente cadastrado com este número de documento");
        }
        return gateway.create(clientes);
    }
}
