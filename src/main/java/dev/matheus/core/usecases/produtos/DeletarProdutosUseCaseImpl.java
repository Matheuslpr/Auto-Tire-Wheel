package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;

public class DeletarProdutosUseCaseImpl implements DeletarProdutosUseCase {

    private final ProdutosGateway gateway;

    public DeletarProdutosUseCaseImpl(ProdutosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Produtos execute(Long id){
        return gateway.delete(id);
    }

}
