package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;

public class CadastrarFuncionariosUseCaseImpl implements CadastrarFuncionariosUseCase {

    private final FuncionariosGateway gateway;

    public CadastrarFuncionariosUseCaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Funcionarios execute(Funcionarios funcionarios){
        return gateway.create(funcionarios);
    }
}
