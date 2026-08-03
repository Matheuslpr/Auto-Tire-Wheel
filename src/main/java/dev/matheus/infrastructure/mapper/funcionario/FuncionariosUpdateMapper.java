package dev.matheus.infrastructure.mapper.funcionario;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.infrastructure.dto.funcionario.FuncionariosRequest;
import org.springframework.stereotype.Component;

@Component
public class FuncionariosUpdateMapper {

    public FuncionariosRequest toDto(Funcionarios funcionarios) {
        return new FuncionariosRequest(
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
                funcionarios.salario()
        );
    }

    public Funcionarios merge(Funcionarios funcionariosExistente, FuncionariosRequest request){
        return new Funcionarios(
                funcionariosExistente.id(),
                request.nome() != null ? request.nome() : funcionariosExistente.nome(),
                request.tipoDocumento() != null ? request.tipoDocumento() : funcionariosExistente.tipoDocumento(),
                request.numeroDocumento() != null ? request.numeroDocumento() : funcionariosExistente.numeroDocumento(),
                request.email() != null ? request.email() : funcionariosExistente.email(),
                request.telefone() != null ? request.telefone() : funcionariosExistente.telefone(),
                request.logradouro() != null ? request.logradouro() : funcionariosExistente.logradouro(),
                request.numero() != null ? request.numero() : funcionariosExistente.numero(),
                request.bairro() != null ? request.bairro() : funcionariosExistente.bairro(),
                request.cidade() != null ? request.cidade() : funcionariosExistente.cidade(),
                request.estado() != null ? request.estado() : funcionariosExistente.estado(),
                request.cep() != null ? request.cep() : funcionariosExistente.cep(),
                request.cargo() != null ? request.cargo() : funcionariosExistente.cargo(),
                request.salario() != null ? request.salario() : funcionariosExistente.salario(),
                funcionariosExistente.dataAdmissao(),
                funcionariosExistente.dataDesligamento()
        );
    }

    public Funcionarios toEntity(FuncionariosRequest request){
        return new Funcionarios(
                null,
                request.nome(),
                request.tipoDocumento(),
                request.numeroDocumento(),
                request.email(),
                request.telefone(),
                request.logradouro(),
                request.numero(),
                request.bairro(),
                request.cidade(),
                request.estado(),
                request.cep(),
                request.cargo(),
                request.salario(),
                java.time.LocalDateTime.now(),
                null
        );
    }
}
