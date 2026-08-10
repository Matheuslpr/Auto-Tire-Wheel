package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.gateway.VendasGateway;

public class BuscarVendasUseCaseImpl implements BuscarVendasUseCase{

    private final VendasGateway gateway;

    public BuscarVendasUseCaseImpl(VendasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Vendas execute(Long id) {
        var venda = gateway.findById(id);
        if (venda == null) {
            throw new IllegalArgumentException("Venda não encontrada");
        }
        return venda;
    }

}
