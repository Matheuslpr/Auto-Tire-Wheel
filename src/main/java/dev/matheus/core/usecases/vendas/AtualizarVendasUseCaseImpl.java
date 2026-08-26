package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class AtualizarVendasUseCaseImpl implements AtualizarVendasUseCase {

    private final VendasGateway gateway;

    public AtualizarVendasUseCaseImpl(VendasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Vendas execute(Vendas vendas) {
        var existente = gateway.findById(vendas.id());
        if (existente == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        if (existente.status() != StatusVenda.ABERTA) {
            throw new IllegalStateException("Somente vendas em aberto podem ser alteradas");
        }
        return gateway.replace(new Vendas(
                existente.id(),
                vendas.clienteId(),
                vendas.funcionarioId(),
                vendas.dataVenda(),
                vendas.formaPagamento(),
                vendas.valorTotal(),
                existente.status(),
                existente.dataCadastro(),
                vendas.dataAtualizacao()
        ));
    }
}