package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;
import dev.matheus.infrastructure.exception.DuplicateException;

public class CadastrarProdutosUseCaseImpl implements CadastrarProdutosUseCase {

    private final ProdutosGateway gateway;

    public CadastrarProdutosUseCaseImpl(ProdutosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Produtos execute(Produtos produtos){
        if (gateway.existsByCodigo(produtos.codigo())) {
            throw new DuplicateException("Já existe um produto cadastrado com este código");
        }
        return gateway.create(produtos);
    }
}
