package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.gateway.ItensVendaGateway;

import java.util.List;

public class ListarItensVendaUseCaseImpl implements ListarItensVendaUseCase{

    private final ItensVendaGateway gateway;

    public ListarItensVendaUseCaseImpl(ItensVendaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ItensVenda> execute(){
        return gateway.findAll();
    }
}
