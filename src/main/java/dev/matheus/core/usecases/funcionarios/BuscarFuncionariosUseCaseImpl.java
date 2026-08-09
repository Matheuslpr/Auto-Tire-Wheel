package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;

public class BuscarFuncionariosUseCaseImpl implements BuscarFuncionariosUseCase{

    private final FuncionariosGateway gateway;

    public BuscarFuncionariosUseCaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Funcionarios execute(Long id){
        var funcionario = gateway.findById(id);
        if(funcionario == null){
            throw  new IllegalArgumentException("Funcionário não encontrado");
        }
        return funcionario;
    }
}
