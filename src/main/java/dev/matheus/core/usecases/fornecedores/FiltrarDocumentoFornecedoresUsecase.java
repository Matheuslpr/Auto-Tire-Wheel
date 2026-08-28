package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;

public interface FiltrarDocumentoFornecedoresUsecase {

    Fornecedores execute(String numeroDocumento);
}
