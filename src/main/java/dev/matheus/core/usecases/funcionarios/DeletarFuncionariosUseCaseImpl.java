package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;

public class DeletarFuncionariosUseCaseImpl implements DeletarFuncionariosUseCase{

    private final FuncionariosGateway gateway;

    public DeletarFuncionariosUseCaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Funcionarios execute(Long id) {
        return gateway.delete(id);
    }
}
