package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.gateway.ItensVendaGateway;

public class DeletarItensVendaUseCaseImpl implements DeletarItensVendaUseCase {

    private final ItensVendaGateway gateway;

    public DeletarItensVendaUseCaseImpl(ItensVendaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ItensVenda execute(Long id){
        return gateway.delete(id);
    }
}
