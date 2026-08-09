package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;

import java.util.List;

public class ListarFuncionariosUseCaseImpl implements ListarFuncionariosUseCase{

    private final FuncionariosGateway gateway;

    public ListarFuncionariosUseCaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Funcionarios> execute() {
        return gateway.findAll();
    }
}
