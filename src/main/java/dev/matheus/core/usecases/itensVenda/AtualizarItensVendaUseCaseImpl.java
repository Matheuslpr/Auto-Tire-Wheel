package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.core.gateway.ItensVendaGateway;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


public class AtualizarItensVendaUseCaseImpl implements AtualizarItensVendaUseCase {

    private final ItensVendaGateway gateway;
    private final VendasGateway vendasGateway;
    private final ItensVendaEstoqueService estoqueService;

    public AtualizarItensVendaUseCaseImpl(ItensVendaGateway gateway, VendasGateway vendasGateway, ItensVendaEstoqueService estoqueService) {
        this.gateway = gateway;
        this.vendasGateway = vendasGateway;
        this.estoqueService = estoqueService;
    }

    @Override
    @Transactional
    public ItensVenda execute(ItensVenda itensVenda) {
        ItensVenda existente = gateway.findById(itensVenda.id());
        if (existente == null) {
            throw new ResourceNotFoundException("Item de venda não encontrado");
        }
        if (!existente.vendaId().equals(itensVenda.vendaId())) {
            throw new IllegalStateException("Não é possível mover um item para outra venda");
        }

        Vendas venda = vendasGateway.findById(existente.vendaId());
        if (venda == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        if (venda.status() != StatusVenda.ABERTA) {
            throw new IllegalStateException("Só é possível alterar itens de vendas em aberto");
        }

        estoqueService.validarExistencia(itensVenda.tipoItem(), itensVenda.itemId());
        estoqueService.restaurarEstoque(existente.tipoItem(), existente.itemId(), existente.quantidade());
        estoqueService.debitarEstoque(itensVenda.tipoItem(), itensVenda.itemId(), itensVenda.quantidade());

        ItensVenda atualizado = gateway.replace(new ItensVenda(
                existente.id(),
                existente.vendaId(),
                itensVenda.tipoItem(),
                itensVenda.itemId(),
                itensVenda.quantidade(),
                itensVenda.precoUnitario(),
                itensVenda.subtotal()
        ));

        vendasGateway.replace(new Vendas(
                venda.id(),
                venda.clienteId(),
                venda.funcionarioId(),
                venda.dataVenda(),
                venda.formaPagamento(),
                venda.valorTotal().subtract(existente.subtotal()).add(itensVenda.subtotal()),
                venda.status(),
                venda.dataCadastro(),
                LocalDateTime.now()
        ));

        return atualizado;
    }
}