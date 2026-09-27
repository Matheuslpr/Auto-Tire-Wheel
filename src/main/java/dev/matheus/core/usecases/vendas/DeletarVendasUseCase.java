package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;

public interface DeletarVendasUseCase {

    Vendas execute(Long id);
}
