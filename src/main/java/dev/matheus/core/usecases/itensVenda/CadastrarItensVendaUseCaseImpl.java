package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.gateway.ItensVendaGateway;

public class CadastrarItensVendaUseCaseImpl implements CadastrarItensVendaUseCase{

    private final ItensVendaGateway gateway;

    public CadastrarItensVendaUseCaseImpl(ItensVendaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ItensVenda execute(ItensVenda itensVenda){
        return gateway.create(itensVenda);
    }

}
