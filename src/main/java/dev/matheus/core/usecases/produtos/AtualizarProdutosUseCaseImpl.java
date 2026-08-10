package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;

public class AtualizarProdutosUseCaseImpl implements AtualizarProdutosUseCase {

    private final ProdutosGateway gateway;

    public AtualizarProdutosUseCaseImpl(ProdutosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Produtos execute(Produtos produtos) {
        var existente = gateway.findById(produtos.id());
        if (existente == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
        return gateway.replace(new Produtos(
                existente.id(),
                produtos.marcaId(),
                produtos.codigo(),
                produtos.nome(),
                produtos.descricao(),
                produtos.precoCusto(),
                produtos.precoVenda(),
                produtos.estoque(),
                existente.dataCadastro(),
                produtos.dataAtualizacao()
        ));
    }
}
