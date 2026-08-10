package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.core.gateway.VendasGateway;

import java.time.LocalDateTime;

public class CancelarVendasUseCaseImpl implements CancelarVendasUseCase{

    private final VendasGateway gateway;

    public CancelarVendasUseCaseImpl(VendasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Vendas execute(Long id) {
        var existente = gateway.findById(id);
        if (existente == null) {
            throw new IllegalArgumentException("Venda não encontrada");
        }
        if (existente.status() == StatusVenda.CANCELADA) {
            throw new IllegalStateException("Venda já está cancelada");
        }
        return gateway.replace(new Vendas(
                existente.id(),
                existente.clienteId(),
                existente.funcionarioId(),
                existente.dataVenda(),
                existente.formaPagamento(),
                existente.valorTotal(),
                StatusVenda.CANCELADA,
                existente.dataCadastro(),
                LocalDateTime.now()
        ));
    }
}