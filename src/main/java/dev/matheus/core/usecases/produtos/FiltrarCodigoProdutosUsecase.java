package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;

public interface FiltrarCodigoProdutosUsecase {

     Produtos execute(String codigo);
}
