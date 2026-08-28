package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class FiltrarDocumentoFornecedoresUsecaseImpl implements FiltrarDocumentoFornecedoresUsecase {

    public final FornecedoresGateway gateway;

    public FiltrarDocumentoFornecedoresUsecaseImpl(FornecedoresGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Fornecedores execute(String numeroDocumento) {
        return gateway.filtrarPorDocumento(numeroDocumento)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor com documento: " + numeroDocumento + " não encontrado."));
    }
}
