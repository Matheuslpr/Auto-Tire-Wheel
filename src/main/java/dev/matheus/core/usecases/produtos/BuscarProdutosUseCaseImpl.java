package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;

public class BuscarProdutosUseCaseImpl implements BuscarProdutosUseCase {

    private final ProdutosGateway gateway;

    public BuscarProdutosUseCaseImpl(ProdutosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Produtos execute(Long id) {
        var produto = gateway.findById(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
        return produto;
    }
}
