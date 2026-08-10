package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;

public class CadastrarProdutosUseCaseImpl implements CadastrarProdutosUseCase {

    private final ProdutosGateway gateway;

    public CadastrarProdutosUseCaseImpl(ProdutosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Produtos execute(Produtos produtos){
        return gateway.create(produtos);
    }
}
