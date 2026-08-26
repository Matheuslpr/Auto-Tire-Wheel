package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;
import dev.matheus.infrastructure.exception.DuplicateException;

public class CadastrarFuncionariosUseCaseImpl implements CadastrarFuncionariosUseCase {

    private final FuncionariosGateway gateway;

    public CadastrarFuncionariosUseCaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Funcionarios execute(Funcionarios funcionarios) {
        if (gateway.existsByNumeroDocumento(funcionarios.numeroDocumento())) {
            throw new DuplicateException("Já existe um funcionário cadastrado com este número de documento");
        }
        return gateway.create(funcionarios);
    }
}