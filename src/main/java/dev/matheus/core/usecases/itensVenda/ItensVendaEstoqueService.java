package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.entities.Produtos;
import dev.matheus.core.entities.Rodas;
import dev.matheus.core.enuns.TipoItemVenda;
import dev.matheus.core.gateway.PneusGateway;
import dev.matheus.core.gateway.ProdutosGateway;
import dev.matheus.core.gateway.RodasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

import java.time.LocalDateTime;

public class ItensVendaEstoqueService {

    private final ProdutosGateway produtosGateway;
    private final PneusGateway pneusGateway;
    private final RodasGateway rodasGateway;

    public ItensVendaEstoqueService(ProdutosGateway produtosGateway, PneusGateway pneusGateway, RodasGateway rodasGateway) {
        this.produtosGateway = produtosGateway;
        this.pneusGateway = pneusGateway;
        this.rodasGateway = rodasGateway;
    }

    public void validarExistencia(TipoItemVenda tipoItem, Long itemId) {
        switch (tipoItem) {
            case PRODUTO -> {
                if (produtosGateway.findById(itemId) == null) {
                    throw new ResourceNotFoundException("Produto com id " + itemId + " não encontrado");
                }
            }
            case PNEU -> {
                if (pneusGateway.findById(itemId) == null) {
                    throw new ResourceNotFoundException("Pneu com id " + itemId + " não encontrado");
                }
            }
            case RODA -> {
                if (rodasGateway.findById(itemId) == null) {
                    throw new ResourceNotFoundException("Roda com id " + itemId + " não encontrada");
                }
            }
        }
    }

    public void debitarEstoque(TipoItemVenda tipoItem, Long itemId, Integer quantidade) {
        ajustarEstoque(tipoItem, itemId, -quantidade);
    }

    public void restaurarEstoque(TipoItemVenda tipoItem, Long itemId, Integer quantidade) {
        ajustarEstoque(tipoItem, itemId, quantidade);
    }

    private void ajustarEstoque(TipoItemVenda tipoItem, Long itemId, int delta) {
        switch (tipoItem) {
            case PRODUTO -> {
                Produtos produto = produtosGateway.findById(itemId);
                if (produto == null) {
                    throw new ResourceNotFoundException("Produto com id " + itemId + " não encontrado");
                }
                int novoEstoque = produto.estoque() + delta;
                if (novoEstoque < 0) {
                    throw new IllegalStateException("Estoque insuficiente para o produto " + produto.nome());
                }
                produtosGateway.replace(new Produtos(
                        produto.id(), produto.marcaId(), produto.codigo(), produto.nome(), produto.descricao(),
                        produto.precoCusto(), produto.precoVenda(), novoEstoque,
                        produto.dataCadastro(), LocalDateTime.now()
                ));
            }
            case PNEU -> {
                Pneus pneu = pneusGateway.findById(itemId);
                if (pneu == null) {
                    throw new ResourceNotFoundException("Pneu com id " + itemId + " não encontrado");
                }
                int novoEstoque = pneu.estoque() + delta;
                if (novoEstoque < 0) {
                    throw new IllegalStateException("Estoque insuficiente para o pneu " + pneu.nome());
                }
                pneusGateway.replace(new Pneus(
                        pneu.id(), pneu.marcaId(), pneu.codigo(), pneu.nome(), pneu.larguraMm(), pneu.perfil(), pneu.aro(),
                        pneu.indiceCarga(), pneu.indiceVelocidade(), pneu.precoCusto(), pneu.precoVenda(), novoEstoque,
                        pneu.dataCadastro(), LocalDateTime.now()
                ));
            }
            case RODA -> {
                Rodas roda = rodasGateway.findById(itemId);
                if (roda == null) {
                    throw new ResourceNotFoundException("Roda com id " + itemId + " não encontrada");
                }
                int novoEstoque = roda.estoque() + delta;
                if (novoEstoque < 0) {
                    throw new IllegalStateException("Estoque insuficiente para a roda " + roda.nome());
                }
                rodasGateway.replace(new Rodas(
                        roda.id(), roda.marcaId(), roda.codigo(), roda.nome(), roda.aro(), roda.larguraPolegadas(), roda.furos(),
                        roda.diametroFuracaoMm(), roda.offsetEtMm(), roda.material(), roda.corAcabamento(),
                        roda.precoCusto(), roda.precoVenda(), novoEstoque,
                        roda.dataCadastro(), LocalDateTime.now()
                ));
            }
        }
    }
}