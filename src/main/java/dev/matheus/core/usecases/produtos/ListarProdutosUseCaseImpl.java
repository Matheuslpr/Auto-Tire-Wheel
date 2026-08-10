package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;

import java.util.List;

public class ListarProdutosUseCaseImpl implements ListarProdutosUseCase{

    private final ProdutosGateway gateway;

    public ListarProdutosUseCaseImpl(ProdutosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Produtos> execute(){
        return gateway.findAll();
    }
}
