package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class FiltrarCodigoProdutosUsecaseImpl implements FiltrarCodigoProdutosUsecase {

    public final ProdutosGateway gateway;

    public FiltrarCodigoProdutosUsecaseImpl(ProdutosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Produtos execute(String codigo) {
         return gateway.filtrarPorCodigo(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com código: " + codigo + " não encontrado."));
    }
}
