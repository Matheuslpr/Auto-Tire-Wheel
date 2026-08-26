package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class BuscarVendasUseCaseImpl implements BuscarVendasUseCase{

    private final VendasGateway gateway;

    public BuscarVendasUseCaseImpl(VendasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Vendas execute(Long id) {
        var venda = gateway.findById(id);
        if (venda == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        return venda;
    }

}
