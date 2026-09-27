package dev.matheus.core.usecases.itensVenda;

import dev.matheus.core.entities.ItensVenda;

import java.util.List;

public interface ListarItensVendaPorVendaUseCase {

    List<ItensVenda> execute(Long vendaId);
}
