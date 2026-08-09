package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.gateway.ItensVendaGateway;

public class BuscarItensVendaUseCaseImpl implements BuscarItensVendaUseCase{

    private final ItensVendaGateway gateway;

    public BuscarItensVendaUseCaseImpl(ItensVendaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ItensVenda execute(Long id){
        var itensVenda = gateway.findById(id);
        if(itensVenda == null){
            throw  new IllegalArgumentException("itens não encontrado");
        }
        return itensVenda;
    }
}
