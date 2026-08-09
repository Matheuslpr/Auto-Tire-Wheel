package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.gateway.ItensVendaGateway;


public class AtualizarItensVendaUseCaseImpl implements AtualizarItensVendaUseCase {

    private final ItensVendaGateway gateway;

    public AtualizarItensVendaUseCaseImpl(ItensVendaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ItensVenda execute(ItensVenda itensVenda){

        var existente = gateway.findById(itensVenda.id());
        if (existente == null) {
            throw new IllegalArgumentException("itens não encontrado");
        }
        return gateway.replace(new ItensVenda(
                existente.id(),
                itensVenda.vendaId(),
                itensVenda.tipoItem(),
                itensVenda.itemId(),
                itensVenda.quantidade(),
                itensVenda.precoUnitario(),
                itensVenda.subtotal()
        ));
    }

}