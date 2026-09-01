package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class FiltrarRegistroFuncionariosUsecaseImpl implements FiltrarRegistroFuncionariosUsecase{

    private final FuncionariosGateway gateway;

    public FiltrarRegistroFuncionariosUsecaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Funcionarios execute(String registro) {
        return gateway.filtrarPorRegistro(registro)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Funcionário com registro: " + registro + " não encontrado."));
    }
}
