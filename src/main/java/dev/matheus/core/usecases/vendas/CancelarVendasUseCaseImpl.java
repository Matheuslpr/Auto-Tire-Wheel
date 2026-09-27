package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.core.gateway.ItensVendaGateway;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.core.usecases.itensVenda.ItensVendaEstoqueService;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class CancelarVendasUseCaseImpl implements CancelarVendasUseCase{

    private final VendasGateway gateway;
    private final ItensVendaGateway itensVendaGateway;
    private final ItensVendaEstoqueService estoqueService;


    public CancelarVendasUseCaseImpl(VendasGateway gateway, ItensVendaGateway itensVendaGateway, ItensVendaEstoqueService estoqueService) {
        this.gateway = gateway;
        this.itensVendaGateway = itensVendaGateway;
        this.estoqueService = estoqueService;
    }

    @Override
    @Transactional
    public Vendas execute(Long id) {
        var existente = gateway.findById(id);
        if (existente == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        if (existente.status() == StatusVenda.CANCELADA) {
            throw new IllegalStateException("Venda já está cancelada");
        }

        for (ItensVenda item : itensVendaGateway.findByVendaId(id)) {
            estoqueService.restaurarEstoque(item.tipoItem(), item.itemId(), item.quantidade());
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