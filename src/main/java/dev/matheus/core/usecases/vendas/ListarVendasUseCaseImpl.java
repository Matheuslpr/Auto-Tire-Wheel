package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.gateway.VendasGateway;

import java.util.List;

public class ListarVendasUseCaseImpl implements ListarVendasUseCase {

    private final VendasGateway gateway;

    public ListarVendasUseCaseImpl(VendasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Vendas> execute() {
        return gateway.findAll();
    }
}