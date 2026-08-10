package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;

import java.util.List;

public interface ListarVendasUseCase {
    List<Vendas> execute();
}
