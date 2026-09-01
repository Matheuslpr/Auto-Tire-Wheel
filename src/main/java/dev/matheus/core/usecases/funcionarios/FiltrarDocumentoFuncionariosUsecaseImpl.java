package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class FiltrarDocumentoFuncionariosUsecaseImpl implements FiltrarDocumentoFuncionariosUsecase {

    private final FuncionariosGateway gateway;

    public FiltrarDocumentoFuncionariosUsecaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Funcionarios execute(String numeroDocumento) {
        return gateway.filtrarPorDocumento(numeroDocumento)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario com documento: " + numeroDocumento + " não encontrado."));
    }
}
