package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class AtualizarFuncionariosUseCaseImpl implements AtualizarFuncionariosUseCase {

    private final FuncionariosGateway gateway;

    public AtualizarFuncionariosUseCaseImpl(FuncionariosGateway gateway) {
        this.gateway = gateway;
    }
    @Override
    public Funcionarios execute(Funcionarios funcionarios) {
        var existente = gateway.findById(funcionarios.id());
        if (existente == null) {
            throw new ResourceNotFoundException("Funcionário não encontrado");
        }
        return gateway.replace(new Funcionarios(
                existente.id(),
                funcionarios.nome(),
                funcionarios.tipoDocumento(),
                funcionarios.numeroDocumento(),
                funcionarios.email(),
                funcionarios.telefone(),
                funcionarios.logradouro(),
                funcionarios.numero(),
                funcionarios.bairro(),
                funcionarios.cidade(),
                funcionarios.estado(),
                funcionarios.cep(),
                funcionarios.cargo(),
                funcionarios.salario(),
                funcionarios.dataAdmissao(),
                funcionarios.dataDesligamento()
        ));
    }
}
