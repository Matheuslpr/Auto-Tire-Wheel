package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.core.gateway.ItensVendaGateway;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class DeletarItensVendaUseCaseImpl implements DeletarItensVendaUseCase {

    private final ItensVendaGateway gateway;
    private final VendasGateway vendasGateway;
    private final ItensVendaEstoqueService estoqueService;

    public DeletarItensVendaUseCaseImpl(ItensVendaGateway gateway, VendasGateway vendasGateway, ItensVendaEstoqueService estoqueService) {
        this.gateway = gateway;
        this.vendasGateway = vendasGateway;
        this.estoqueService = estoqueService;
    }

    @Override
    @Transactional
    public ItensVenda execute(Long id) {
        ItensVenda existente = gateway.findById(id);
        if (existente == null) {
            throw new ResourceNotFoundException("Item de venda não encontrado");
        }

        Vendas venda = vendasGateway.findById(existente.vendaId());
        if (venda == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        if (venda.status() != StatusVenda.ABERTA) {
            throw new IllegalStateException("Só é possível remover itens de vendas em aberto");
        }

        estoqueService.restaurarEstoque(existente.tipoItem(), existente.itemId(), existente.quantidade());

        ItensVenda deletado = gateway.delete(id);

        vendasGateway.replace(new Vendas(
                venda.id(),
                venda.clienteId(),
                venda.funcionarioId(),
                venda.dataVenda(),
                venda.formaPagamento(),
                venda.valorTotal().subtract(existente.subtotal()),
                venda.status(),
                venda.dataCadastro(),
                LocalDateTime.now()
        ));

        return deletado;
    }
}
