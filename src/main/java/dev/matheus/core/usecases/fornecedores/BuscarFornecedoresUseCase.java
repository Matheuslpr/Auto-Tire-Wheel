package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;

public interface BuscarFornecedoresUseCase {
    Fornecedores execute(Long id);

}
