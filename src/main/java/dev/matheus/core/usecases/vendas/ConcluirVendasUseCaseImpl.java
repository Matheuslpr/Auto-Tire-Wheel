package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

import java.time.LocalDateTime;

public class ConcluirVendasUseCaseImpl implements ConcluirVendasUseCase {

    private final VendasGateway gateway;

    public ConcluirVendasUseCaseImpl(VendasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Vendas execute(Long id) {
        var existente = gateway.findById(id);
        if (existente == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        if (existente.status() != StatusVenda.ABERTA) {
            throw new IllegalStateException("Somente vendas em aberto podem ser concluídas");
        }
        return gateway.replace(new Vendas(
                existente.id(),
                existente.clienteId(),
                existente.funcionarioId(),
                existente.dataVenda(),
                existente.formaPagamento(),
                existente.valorTotal(),
                StatusVenda.FINALIZADA,
                existente.dataCadastro(),
                LocalDateTime.now()
        ));
    }
}