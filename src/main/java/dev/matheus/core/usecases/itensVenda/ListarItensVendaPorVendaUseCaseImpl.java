package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.gateway.ItensVendaGateway;

import java.util.List;

public class ListarItensVendaPorVendaUseCaseImpl implements ListarItensVendaPorVendaUseCase {

    private final ItensVendaGateway gateway;

    public ListarItensVendaPorVendaUseCaseImpl(ItensVendaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ItensVenda> execute(Long vendaId) {
        return gateway.findByVendaId(vendaId);
    }
}
