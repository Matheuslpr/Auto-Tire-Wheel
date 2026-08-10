package dev.matheus.core.usecases.produtos;

import dev.matheus.core.entities.Produtos;

import java.util.List;

public interface ListarProdutosUseCase {

    List<Produtos> execute();

}
