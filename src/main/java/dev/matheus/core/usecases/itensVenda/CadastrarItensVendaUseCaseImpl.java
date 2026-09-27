package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.core.gateway.ItensVendaGateway;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.exception.DuplicateException;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class CadastrarItensVendaUseCaseImpl implements CadastrarItensVendaUseCase{

    private final ItensVendaGateway gateway;
    private final VendasGateway vendasGateway;
    private final ItensVendaEstoqueService estoqueService;

    public CadastrarItensVendaUseCaseImpl(ItensVendaGateway gateway, VendasGateway vendasGateway, ItensVendaEstoqueService estoqueService) {
        this.gateway = gateway;
        this.vendasGateway = vendasGateway;
        this.estoqueService = estoqueService;
    }

    @Override
    @Transactional
    public ItensVenda execute(ItensVenda itensVenda) {
        Vendas venda = vendasGateway.findById(itensVenda.vendaId());
        if (venda == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        if (venda.status() != StatusVenda.ABERTA) {
            throw new IllegalStateException("Só é possível adicionar itens a vendas em aberto");
        }
        if (gateway.existsDuplicado(itensVenda.vendaId(), itensVenda.tipoItem(), itensVenda.itemId())) {
            throw new DuplicateException("Este item já foi adicionado a esta venda");
        }

        estoqueService.validarExistencia(itensVenda.tipoItem(), itensVenda.itemId());
        estoqueService.debitarEstoque(itensVenda.tipoItem(), itensVenda.itemId(), itensVenda.quantidade());

        ItensVenda criado = gateway.create(itensVenda);

        vendasGateway.replace(new Vendas(
                venda.id(),
                venda.clienteId(),
                venda.funcionarioId(),
                venda.dataVenda(),
                venda.formaPagamento(),
                venda.valorTotal().add(itensVenda.subtotal()),
                venda.status(),
                venda.dataCadastro(),
                LocalDateTime.now()
        ));

        return criado;
    }

}
